package org.pjm.navermapapp

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker

class Map2Activity : AppCompatActivity(), OnMapReadyCallback { // OnMapReadyCallback : 지도를 제어할 때 필요
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map2)

        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(35.1798159, 129.075822), 12.0))
            .mapType(NaverMap.MapType.Terrain)

        // fragment transaction 방식으로 지도를 표시하는 방법
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance(options).also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
        // 지도 객체
        naverMap.mapType = NaverMap.MapType.Basic
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRAFFIC, true)

        // 좌표 객체
        val coord = LatLng(37.5670135, 126.9783740)
        Log.d("aaaaaaa", "위도: ${coord.latitude}, 경도: ${coord.longitude}")

        // 카메라 제어
        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.5670135, 126.9783740))
            .animate(CameraAnimation.Fly, 5000)
        naverMap.moveCamera(cameraUpdate)

        // 마커 찍기
        val marker = Marker()
        marker.position = LatLng(37.5670135, 126.9783740)
        marker.map = naverMap
    }
}