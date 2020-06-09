package kr.co.tjoeun.library_20200609

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        profileImg.setOnClickListener {

            val myIntent = Intent(mContext, LargePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

        Glide.with(mContext).load("http://img4.yna.co.kr/photo/cms/2019/05/02/02/PCM20190502000402370_P2.jpg").into(profileImg)

    }

}
