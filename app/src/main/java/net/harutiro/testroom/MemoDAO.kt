package net.harutiro.testroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDAO {

    @Insert
    fun insert(memo:Memo)

    //クエリの中身
    @Query("select * from memo")
    fun getAll(): LiveData<List<Memo>>
    //変更があったときに自動で取得をしてくれる。
}