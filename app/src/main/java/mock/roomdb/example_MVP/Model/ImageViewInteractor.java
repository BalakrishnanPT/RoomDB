package mock.roomdb.example_MVP.Model;

import java.util.List;

import mock.roomdb.data.db.UserKt;

/**
 * Created by BalaKrishnan on 23-02-2018.
 */

public interface ImageViewInteractor {
    List<UserKt> changeText(String s, String r);
}
