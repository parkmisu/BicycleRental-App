package com.example.tmaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback {

    String API_Key = "l7xxea60bb482a7a4822b131b899ddb7b3e5";

    // T Map View
    TMapView tMapView = null;

    // T Map GPS
    TMapGpsManager tMapGPS = null;

    // Initial Location
    double initialLatitude = 37.55616830335138;
    double initialLongitude = 126.97230717385017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnmenu = (ImageButton) findViewById(R.id.btnmenu);
        ImageButton btnguide = (ImageButton) findViewById(R.id.btnguide);
        ImageButton btnrent = (ImageButton) findViewById(R.id.rentbtn);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent1);
            }
        });

        btnrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent2);
            }
        });

        btnguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), GuideActivity.class);
                startActivity(intent3);
            }
        });

        // T Map View
        tMapView = new TMapView(this);
        initTMapView();

        // T Map GPS
        initTMapGPS();

        // Load Database  BikeRentPlace bikeRentPlace = new BikeRentPlace();
        List<BikeRentPlace> PlaceList = initLoadBikeRentPlaceDatabase();

        // Add Marker
        addBikeRentPlaceMarker(PlaceList);

        // T Map View Using Linear Layout
        LinearLayout linearLayoutTMap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        linearLayoutTMap.addView(tMapView);
    }

    public void initTMapView(){
        // API Key
        tMapView.setSKTMapApiKey(API_Key);

        // Initial Setting
        tMapView.setZoomLevel(17);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);

        // Initial Location Setting
        tMapView.setLocationPoint(initialLongitude, initialLatitude);
        tMapView.setCenterPoint(initialLongitude, initialLatitude);
    }

    public void initTMapGPS(){
        // Request For GPS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // T Map GPS
        tMapGPS = new TMapGpsManager(this);

        // Initial Setting
        tMapGPS.setMinTime(1000);
        tMapGPS.setMinDistance(10);
        tMapGPS.setProvider(tMapGPS.NETWORK_PROVIDER);
        //tMapGPS.setProvider(tMapGPS.GPS_PROVIDER);

        // Using GPS
        tMapGPS.OpenGps();
    }

    @Override
    public void onLocationChange(Location location) {
        tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        tMapView.setCenterPoint(location.getLongitude(), location.getLatitude());
    }

    public List<BikeRentPlace> initLoadBikeRentPlaceDatabase(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.OpenDatabaseFile();

        List<BikeRentPlace> PlaceList = databaseHelper.getTableData();
        Log.e("test", String.valueOf(PlaceList.size()));

        databaseHelper.close();
        return  PlaceList;
    }

    public void addBikeRentPlaceMarker(List<BikeRentPlace> PlaceList){

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.markerline_green);

        for (int i = 0; i < PlaceList.size(); i++){
            int Num =PlaceList.get(i).Num;
            String Place = PlaceList.get(i).Place;
            String Address = PlaceList.get(i).Address;
            double Longtitude = PlaceList.get(i).Longtitude;
            double Latitude = PlaceList.get(i).Latitude;
            int LCD = PlaceList.get(i).LCD;
            int QR = PlaceList.get(i).QR;

            // TMapPoint
            TMapPoint tMapPoint = new TMapPoint(Longtitude, Latitude);

            // TMapMarkerItem
            // Marker Initial Settings
            TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();
            tMapMarkerItem.setIcon(bitmap);
            tMapMarkerItem.setPosition(0.5f, 1.0f);
            tMapMarkerItem.setTMapPoint(tMapPoint);
            tMapMarkerItem.setName(Place);

            // Balloon View Initial Settings
            tMapMarkerItem.setCanShowCallout(true);     // Balloon View 사용
            tMapMarkerItem.setCalloutTitle(Place);  // Main Message
            tMapMarkerItem.setCalloutSubTitle(String.valueOf("LCD자전거 :"+LCD+"개 \r\n"+"QR자전거 :"+QR+"개")); // Sub Message
            tMapMarkerItem.setAutoCalloutVisible(true); // 초기 접속 시 Balloon View
           //tMapMarkerItem.setCalloutRightButtonImage(bitmap2);

            // add Marker on T Map View
            // id로 마커를 식별
            tMapView.addMarkerItem("PlaceLocation" + i, tMapMarkerItem);

            /*//여기부터 길찾기
            TMapData tmapdata = new TMapData();
            TMapPoint startpoint = new TMapPoint(37.55616830335138,126.97230717385017);
            TMapPoint endpoint = new TMapPoint(37.55738520516722, 126.97719840957298);

            tmapdata.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, startpoint, endpoint, new TMapData.FindPathDataListenerCallback() {
                @Override
                public void onFindPathData(TMapPolyLine tMapPolyLine) {
                    tMapView.addTMapPath(tMapPolyLine);
                }
            });//여기까지 길찾기*/
        }
        /*//여기부터 길찾기
        TMapData tmapdata = new TMapData();
        TMapPoint startpoint = new TMapPoint(37.55616830335138,126.97230717385017);
        TMapPoint endpoint = new TMapPoint(37.55738520516722, 126.97719840957298);

        tmapdata.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, startpoint, endpoint, new TMapData.FindPathDataListenerCallback() {
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tMapView.addTMapPath(tMapPolyLine);
            }
        });//여기까지 길찾기*/
    }

   /* public void setPathPolyLine(){
        //여기부터 길찾기
        TMapData tmapdata = new TMapData();
        TMapPoint startpoint = new TMapPoint(37.55616830335138, 126.97230717385017);
        TMapPoint endpoint = new TMapPoint(37.55738520516722, 126.97719840957298);

        tmapdata.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, startpoint, endpoint, new TMapData.FindPathDataListenerCallback() {
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tMapView.addTMapPath(tMapPolyLine);
            }
        });//여기까지 길찾기
    }*/
    //여기부터 길찾기
    /*TMapData tmapdata = new TMapData();
    TMapPoint startpoint = new TMapPoint(37.55616830335138,126.97230717385017);
    TMapPoint endpoint = new TMapPoint(37.55738520516722, 126.97719840957298);

    public TMapData getTmapdata() {
        //return tmapdata;
        tmapdata.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, startpoint, endpoint, new TMapData.FindPathDataListenerCallback(){
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tMapView.addTMapPath(tMapPolyLine);
            }
        });
        return tmapdata;
    }*/
}