package mock.roomdb;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.ref.WeakReference;

import mock.roomdb.data.db.AppDatabase;


public class MainActivity extends AppCompatActivity {
    //static RuntimeExceptionDao<Orm_User, Integer> healperDao;
    private static final String TAG = MainActivity.class.getName();

    public static final String MESSENGER_INTENT_KEY
            = BuildConfig.APPLICATION_ID + ".MESSENGER_INNT_KEY";

    private int mJobId = 0;
    private ComponentName mServiceComponent;
    private IncomingMessageHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mServiceComponent = new ComponentName(this, MyJobService.class);

        mHandler = new IncomingMessageHandler(this);

       // Orm_User orm_user = new Orm_User("Bala","Krishnan",21);

//        activityMainBinding.clickHereBtn.setOnClickListener(view ->
//               // DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this))
//                //  healperDao.create(orm_user)
//                scheduleJob()
//          );
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
    public void scheduleJob() {
        JobInfo.Builder builder = new JobInfo.Builder(mJobId++, mServiceComponent);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        Log.d(TAG, "Scheduling job");
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.schedule(builder.build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Start service and provide it a way to communicate with this class.
        Intent startServiceIntent = new Intent(this, MyJobService.class);
        Messenger messengerIncoming = new Messenger(mHandler);
        startServiceIntent.putExtra(MESSENGER_INTENT_KEY, messengerIncoming);
        startService(startServiceIntent);
    }

    @Override
    protected void onStop() {
        // A service can be "started" and/or "bound". In this case, it's "started" by this Activity
        // and "bound" to the JobScheduler (also called "Scheduled" by the JobScheduler). This call
        // to stopService() won't prevent scheduled jobs to be processed. However, failing
        // to call stopService() would keep it alive indefinitely.

        // stopService(new Intent(this, MyJobService.class));
        super.onStop();
    }

    private class IncomingMessageHandler extends Handler {

        // Prevent possible leaks with a weak reference.
        private WeakReference<MainActivity> mActivity;

        IncomingMessageHandler(MainActivity activity) {
            super(/* default looper */);
            this.mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity mainActivity = mActivity.get();
            if (mainActivity == null) {
                // Activity is no longer available, exit.
                //return;
                Log.d(TAG, "handleMessage: Activity is null");
            }
            Log.d(TAG, "handleMessage: "+msg.toString());

        }

    }


}
