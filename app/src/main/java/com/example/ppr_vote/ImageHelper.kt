package com.example.ppr_vote

import android.graphics.*
import android.graphics.Bitmap
import android.graphics.Shader
import android.graphics.BitmapShader
import com.squareup.picasso.Transformation
import kotlin.math.min


object ImageHelper : Transformation {
    override fun transform (source: Bitmap): Bitmap {
        val size = min(source.width, source.height);

        val x = (source.getWidth() - size) / 2;
        val y = (source.getHeight() - size) / 2;

        val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        val bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        val canvas = Canvas(bitmap);
        val paint = Paint();
        val shader = BitmapShader(squaredBitmap,
            Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.shader = shader;
        paint.isAntiAlias = true;

        val r = size / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();
        return bitmap;
    }

    override fun key(): String = "circle";

}