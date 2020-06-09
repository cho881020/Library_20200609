package kr.co.tjoeun.library_20200609

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                    허가가 나면 실행 할 내용 => 실제 전화 연결
                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    거부되면 실행할 내용
                    Toast.makeText(mContext, "전화 권한이 거부되어 통화가 불가능합니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("권한을 거부하면 통화 할 수 없습니다. [설정] > [권한] 에서 권한설정을 해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()



        }

        profileImg.setOnClickListener {

            val myIntent = Intent(mContext, LargePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

        Glide.with(mContext).load("http://img4.yna.co.kr/photo/cms/2019/05/02/02/PCM20190502000402370_P2.jpg").into(profileImg)

    }

}
