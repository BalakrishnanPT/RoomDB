package mock.roomdb.example_MVP.Presenter;

import android.util.Log;

import java.util.List;

import mock.roomdb.data.db.UserKt;
import mock.roomdb.example_MVP.Model.ImageViewInteractor;
import mock.roomdb.example_MVP.Model.ModelLoadKt;
import mock.roomdb.example_MVP.View.ImageView;

/**
 * Created by BalaKrishnan on 23-02-2018.
 */

public class ImageViewPresenterImpl implements ImageViewPresenter{
    ImageView imageView;
    ImageViewInteractor imageViewInteractor;
    ModelLoadKt modelLoadKt;

    public ImageViewPresenterImpl(ImageView imageView,ImageViewInteractor imageViewInteractor){
        this.imageView = imageView;
        this.imageViewInteractor = imageViewInteractor;
    }
    public ImageViewPresenterImpl(ImageView imageView, ModelLoadKt modelLoadKt){
        this.imageView = imageView;
        this.modelLoadKt=modelLoadKt;
    }

    private String TAG = "IV_Presenter";

    @Override
    public void newText(String n, String r) {
        Log.d(TAG, "newText: ");
        imageView.buttonOnclick( modelLoadKt.changeText(n,r));
    }

}
