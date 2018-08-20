package e.sh.karamozibd.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import e.sh.karamozibd.entity.User;

@Dao
public interface daoUser {

    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("Select * FROM USER WHERE id==:userId")
    User[] loadPostUsers(String userId);
}