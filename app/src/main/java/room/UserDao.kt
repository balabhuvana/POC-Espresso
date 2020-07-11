package room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User?): Long

    @Query("SELECT * from user_table where user_name = :userName LIMIT 1")
    fun getUserRecord(userName: Int): User


}