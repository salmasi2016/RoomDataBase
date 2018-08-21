package e.sh.karamozibd.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import e.sh.karamozibd.entity.Comment;

@Dao
public interface daoComment {

    @Insert
    void insert(Comment... comments);

    @Update
    void update(Comment... comments);

    @Delete
    void delete(Comment... comments);

    @Query("Select * FROM Comment WHERE postId==:postId")
    Comment[] loadPostComments(int postId);

    @Query("Select * FROM Comment WHERE userId==:userId")
    Comment[] loadUserComments(int userId);

    @Query("Select COUNT(*) FROM Comment WHERE userId==:userId")
    int countUserComments(int userId);
}