package ru.egslava.blurredview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.ms.square.android.etsyblur.Blur;
import com.ms.square.android.etsyblur.Util;

import java.lang.Override;
import java.security.InvalidParameterException;

/**
 * Created by egslava on 04/05/15.
 */
public class BlurredImageView extends ImageView {

    public boolean isBlurred = false;

    public float radius = 0.3f, downSampling = 3;
    public boolean keepOriginal = false;

    public Bitmap bitmap;

    public BlurredImageView(Context context) { super(context); antiPreview();}
    public BlurredImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (antiPreview()) return;

        final TypedArray obtained = context.obtainStyledAttributes(attrs, R.styleable.BlurredImageView);
        setRadius( obtained.getFloat(R.styleable.BlurredImageView_radius, radius) );
        keepOriginal = obtained.getBoolean(R.styleable.BlurredImageView_keepOriginal, keepOriginal);
        downSampling = obtained.getFloat(R.styleable.BlurredImageView_downSampling, downSampling);
    }

    /** Preview crashes in RenderScript code */
    boolean antiPreview() { if ( isInEditMode() ) setRadius(0); return isInEditMode(); }

    public void setRadius(float radius) {
        if (radius < 0 || radius > 1) throw new InvalidParameterException();
        this.radius = radius;
        isBlurred   = false;
        invalidate();
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if ( isBlurred || radius <= 0 || radius > 1) return;
        final int width = getMeasuredWidth(), height = getMeasuredHeight();

        final int blurRadius = (int) (radius * 25.f);
        if(blurRadius == 0) return;

        isBlurred = true; // should be called before Util.drawViewToBitmap (or you can bump into recursion)

        if (bitmap == null) bitmap = Util.drawViewToBitmap(this, width, height, 2);
        final Bitmap blurred = Blur.apply(getContext(), bitmap, blurRadius );
        setImageBitmap( blurred );

        if ( ! keepOriginal) {
            bitmap.recycle();
            bitmap = null;
        }
    }
}
