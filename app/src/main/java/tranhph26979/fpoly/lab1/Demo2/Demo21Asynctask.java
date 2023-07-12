package tranhph26979.fpoly.lab1.Demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import tranhph26979.fpoly.lab1.R;

public class Demo21Asynctask extends AsyncTask<String,Void, Bitmap> {
    private Demo21Interface anInterface;//lang nghe va tra ket qua
    private Context context;
    public Demo21Asynctask(Demo21Interface anInterface, Context context) {
        this.anInterface = anInterface;
        this.context=context;
    }
    //ham doc du lieu tu server
    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //tra ket qua ve client
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap!=null)//neu ton tai anh
        {
            anInterface.onLoadAnh(bitmap);//tra anh ve client
        }
        else {
            anInterface.onLoi();
        }
    }
}