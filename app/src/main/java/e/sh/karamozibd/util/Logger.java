package e.sh.karamozibd.util;

import android.util.Log;

import e.sh.karamozibd.entity.Comment;
import e.sh.karamozibd.entity.User;

public class Logger {

    public static void displayPostUsersInLog(User[] users) {
        Log.i("sina", "***PostUsers***");
        if (users == null) {
            return;
        }
        for (User user : users) {
            Log.i("sina", "id: " + user.getId()
                    + ", name: " + user.getName()
                    + ", family: " + user.getFamily());
        }
    }

    public static void displayPostCommentsInLog(Comment[] comments) {
        Log.i("sina", "***PostComments***");
        if (comments == null) {
            return;
        }
        for (Comment comment : comments) {
            Log.i("sina", "id: " + comment.getId()
                    + ", name: " + comment.getUsername()
                    + ", family: " + comment.getText());
        }
    }

    public static void displayUserCommentsInLog(Comment[] comments) {
        Log.i("sina", "***UserComments***");
        if (comments == null) {
            return;
        }
        for (Comment comment : comments) {
            Log.i("sina", "id: " + comment.getId()
                    + ", name: " + comment.getUsername()
                    + ", family: " + comment.getText());
        }
    }

    public static void displayCountUserCommentsInLog(int count) {
        Log.i("sina", "***CountUserComments***");
            Log.i("sina","count: "+count);
    }
}