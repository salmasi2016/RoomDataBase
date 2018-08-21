package e.sh.karamozibd.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import e.sh.karamozibd.dao.daoComment;
import e.sh.karamozibd.dao.daoPost;
import e.sh.karamozibd.dao.daoUser;
import e.sh.karamozibd.entity.Comment;
import e.sh.karamozibd.entity.Post;
import e.sh.karamozibd.entity.User;

@Database(entities = {User.class, Post.class, Comment.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDataBase;

    public abstract daoUser daoUser();

    public abstract daoPost daoPost();

    public abstract daoComment daoComment();

    public static AppDataBase newInstance(Context context) {
        if (appDataBase == null) {
            appDataBase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "appDataBase")
                    .build();
        }
        return appDataBase;
    }
}