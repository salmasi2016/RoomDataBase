package e.sh.karamozibd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import e.sh.karamozibd.database.AppDataBase;
import e.sh.karamozibd.util.DataGenerator;
import e.sh.karamozibd.util.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppDataBase appDataBase=AppDataBase.newInstance(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                DataGenerator.with(appDataBase).generateUser();
                DataGenerator.with(appDataBase).generatePost();
                DataGenerator.with(appDataBase).generateComment();

                Logger.displayPostUsersInLog(appDataBase.daoUser().loadPostUsers(211));
                Logger.displayPostCommentsInLog(appDataBase.daoComment().loadPostComments(212));
                Logger.displayUserCommentsInLog(appDataBase.daoComment().loadUserComments(111));
                Logger.displayCountUserCommentsInLog(appDataBase.daoComment().countUserComments(111));
            }
        }).start();
    }
}