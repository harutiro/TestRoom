package net.harutiro.testroom

import androidx.room.Entity
import androidx.room.PrimaryKey

//memoテーブルを作ってくれる
@Entity
data class Memo(
    //プライマリーキーの作成自動でIDも割り振られる
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var memo:String,
)
