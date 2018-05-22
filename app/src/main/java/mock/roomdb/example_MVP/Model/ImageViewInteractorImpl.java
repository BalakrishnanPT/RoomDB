package mock.roomdb.example_MVP.Model;

import android.util.Log;

import java.util.List;
import java.util.Random;

import mock.roomdb.data.db.UserKt;

/**
 * Created by BalaKrishnan on 23-02-2018.
 */

public class ImageViewInteractorImpl implements ImageViewInteractor {
    private String TAG = "IV_Interactor";

    @Override
    public List<UserKt> changeText(String s,String r) {
        Random rand = new Random();
        int i = rand.nextInt(10);
        Log.d(TAG, "changeText: ");
        return null;
    }
}
