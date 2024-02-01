package org.pjm.navermapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naver.maps.map.NaverMapSdk

class Map1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map1)

        // API를 호출해 지정하는 방식 - 한 엑티비티에서만 지도를 사용한다면 이 방식 사용
        // manifests에 등록하여 사용하는 방식 - 여러 엑티비티에서 지도를 사용해야 한다면 이 방식 사용
//        NaverMapSdk.getInstance(this).client =
//            NaverMapSdk.NaverCloudPlatformClient("wy7f3ryvsg")
    }
}