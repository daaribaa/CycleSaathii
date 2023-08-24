package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView rcv;

    TextView disTv, timeTv;
    Button homeBtn, sharebtn;
    Double totalDistance, totalTime;
    String formattedDistance;
    OsmMapActivity osMapActivity;

    List<double[]> coordinates = new ArrayList<>();
    List<double[]> coordinatesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        algoWork();

        disTv = findViewById(R.id.disTV);
        formattedDistance = String.format("%.2f", totalDistance);
        disTv.setText(formattedDistance + " Km");

        timeTv = findViewById(R.id.timeTV);
        timeTv.setText(String.valueOf(totalTime + " mins"));


        //Coordinates from OsmMapActivity
        double[][] rawCoordinates = (double[][]) getIntent().getSerializableExtra("coordinatesList");
        coordinatesList.addAll(Arrays.asList(rawCoordinates));


        homeBtn = findViewById(R.id.goToHomePage);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DetailsActivity.this,HomePageActivity.class);
                startActivity(in);
            }
        });

        sharebtn = findViewById(R.id.sharebtn);
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this,"Share options not available now",Toast.LENGTH_LONG);

            }
        });
    }

    //Algorithm Ko Kaam
    public void algoWork(){

        coordinates.add(new double[]{27.7169605,85.30460040450451});
        coordinates.add(new double[]{27.717078414181564,85.30459886092332});
        coordinates.add(new double[]{27.717196247550643,85.30459423123763});
        coordinates.add(new double[]{27.717313919350126,85.30458651862043});
        coordinates.add(new double[]{27.717431348933637,85.30457572835752});
        coordinates.add(new double[]{27.71754845582081,85.30456186784403});
        coordinates.add(new double[]{27.717665159752432,85.30454494657926});
        coordinates.add(new double[]{27.71778138074546,85.3045249761602});
        coordinates.add(new double[]{27.717897039147825,85.30450197027358});
        coordinates.add(new double[]{27.718012055693045,85.30447594468647});
        coordinates.add(new double[]{27.718126351554513,85.30444691723554});
        coordinates.add(new double[]{27.718239848399566,85.30441490781472});
        coordinates.add(new double[]{27.71835246844313,85.30437993836169});
        coordinates.add(new double[]{27.71846413450105,85.30434203284275});
        coordinates.add(new double[]{27.718574770042995,85.30430121723647});
        coordinates.add(new double[]{27.718684299244888,85.30425751951582});
        coordinates.add(new double[]{27.718792647040882,85.30421096962903});
        coordinates.add(new double[]{27.718899739174812,85.30416159947906});
        coordinates.add(new double[]{27.71900550225108,85.30410944290175});
        coordinates.add(new double[]{27.71910986378495,85.30405453564262});
        coordinates.add(new double[]{27.71921275225225,85.30399691533236});
        coordinates.add(new double[]{27.71931409713836,85.30393662146106});
        coordinates.add(new double[]{27.719413828986553,85.30387369535111});
        coordinates.add(new double[]{27.719511879445605,85.30380818012893});
        coordinates.add(new double[]{27.71960818131663,85.30374012069538});
        coordinates.add(new double[]{27.719702668599137,85.30366956369501});
        coordinates.add(new double[]{27.71979527653626,85.30359655748404});
        coordinates.add(new double[]{27.719885941659143,85.3035211520973});
        coordinates.add(new double[]{27.719974601830444,85.30344339921386});
        coordinates.add(new double[]{27.720061196286906,85.30336335212168});
        coordinates.add(new double[]{27.72014566568102,85.30328106568102});
        coordinates.add(new double[]{27.720227952121675,85.30319659628691});
        coordinates.add(new double[]{27.720307999213862,85.30311000183045});
        coordinates.add(new double[]{27.720385752097297,85.30302134165915});
        coordinates.add(new double[]{27.72046115748404,85.30293067653626});
        coordinates.add(new double[]{27.720534163695003,85.30283806859914});
        coordinates.add(new double[]{27.72060472069538,85.30274358131663});
        coordinates.add(new double[]{27.720672780128925,85.30264727944561});
        coordinates.add(new double[]{27.720738295351104,85.30254922898655});
        coordinates.add(new double[]{27.720801221461052,85.30244949713837});
        coordinates.add(new double[]{27.720861515332363,85.30234815225225});
        coordinates.add(new double[]{27.72091913564262,85.30224526378495});
        coordinates.add(new double[]{27.720974042901748,85.30214090225108});
        coordinates.add(new double[]{27.721026199479052,85.30203513917482});
        coordinates.add(new double[]{27.72107556962902,85.30192804704089});
        coordinates.add(new double[]{27.721122119515815,85.30181969924489});
        coordinates.add(new double[]{27.72116581723647,85.301710170043});
        coordinates.add(new double[]{27.721206632842758,85.30159953450105});
        coordinates.add(new double[]{27.721244538361688,85.30148786844313});
        coordinates.add(new double[]{27.72127950781472,85.30137524839957});
        coordinates.add(new double[]{27.721311517235534,85.30126175155452});
        coordinates.add(new double[]{27.721340544686473,85.30114745569304});
        coordinates.add(new double[]{27.721366570273574,85.30103243914783});
        coordinates.add(new double[]{27.721389576160195,85.30091678074547});
        coordinates.add(new double[]{27.721409546579256,85.30080055975243});
        coordinates.add(new double[]{27.721426467844026,85.30068385582081});
        coordinates.add(new double[]{27.721440328357513,85.30056674893365});
        coordinates.add(new double[]{27.72145111862042,85.30044931935012});
        coordinates.add(new double[]{27.721458831237634,85.30033164755065});
        coordinates.add(new double[]{27.721463460923314,85.30021381418157});
        coordinates.add(new double[]{27.721465004504502,85.3000959});
        coordinates.add(new double[]{27.721463460923314,85.29997798581843});
        coordinates.add(new double[]{27.721458831237634,85.29986015244936});
        coordinates.add(new double[]{27.72145111862042,85.29974248064988});
        coordinates.add(new double[]{27.721440328357513,85.29962505106636});
        coordinates.add(new double[]{27.721426467844026,85.2995079441792});
        coordinates.add(new double[]{27.721409546579256,85.29939124024757});
        coordinates.add(new double[]{27.721389576160195,85.29927501925454});
        coordinates.add(new double[]{27.721366570273574,85.29915936085217});
        coordinates.add(new double[]{27.721340544686473,85.29904434430696});
        coordinates.add(new double[]{27.721311517235534,85.29893004844548});
        coordinates.add(new double[]{27.72127950781472,85.29881655160044});
        coordinates.add(new double[]{27.721244538361688,85.29870393155687});
        coordinates.add(new double[]{27.721206632842758,85.29859226549895});
        coordinates.add(new double[]{27.72116581723647,85.29848162995701});
        coordinates.add(new double[]{27.721122119515815,85.29837210075512});
        coordinates.add(new double[]{27.72107556962902,85.29826375295912});
        coordinates.add(new double[]{27.721026199479052,85.29815666082519});
        coordinates.add(new double[]{27.720974042901748,85.29805089774892});
        coordinates.add(new double[]{27.72091913564262,85.29794653621505});
        coordinates.add(new double[]{27.720861515332363,85.29784364774775});
        coordinates.add(new double[]{27.720801221461052,85.29774230286164});
        coordinates.add(new double[]{27.720738295351104,85.29764257101345});
        coordinates.add(new double[]{27.720672780128925,85.2975445205544});
        coordinates.add(new double[]{27.72060472069538,85.29744821868337});
        coordinates.add(new double[]{27.720534163695003,85.29735373140086});
        coordinates.add(new double[]{27.72046115748404,85.29726112346374});
        coordinates.add(new double[]{27.720385752097297,85.29717045834086});
        coordinates.add(new double[]{27.720307999213862,85.29708179816956});
        coordinates.add(new double[]{27.720227952121675,85.2969952037131});
        coordinates.add(new double[]{27.72014566568102,85.29691073431898});
        coordinates.add(new double[]{27.720061196286906,85.29682844787833});
        coordinates.add(new double[]{27.719974601830444,85.29674840078614});
        coordinates.add(new double[]{27.719885941659143,85.2966706479027});
        coordinates.add(new double[]{27.71979527653626,85.29659524251596});
        coordinates.add(new double[]{27.719702668599137,85.296522236305});
        coordinates.add(new double[]{27.71960818131663,85.29645167930462});
        coordinates.add(new double[]{27.719511879445605,85.29638361987108});
        coordinates.add(new double[]{27.719413828986553,85.29631810464889});
        coordinates.add(new double[]{27.71931409713836,85.29625517853894});
        coordinates.add(new double[]{27.71921275225225,85.29619488466764});
        coordinates.add(new double[]{27.71910986378495,85.29613726435738});
        coordinates.add(new double[]{27.71900550225108,85.29608235709826});
        coordinates.add(new double[]{27.718899739174812,85.29603020052095});
        coordinates.add(new double[]{27.718792647040882,85.29598083037098});
        coordinates.add(new double[]{27.718684299244888,85.29593428048419});
        coordinates.add(new double[]{27.718574770042995,85.29589058276353});
        coordinates.add(new double[]{27.71846413450105,85.29584976715725});
        coordinates.add(new double[]{27.71835246844313,85.29581186163831});
        coordinates.add(new double[]{27.718239848399566,85.29577689218529});
        coordinates.add(new double[]{27.718126351554513,85.29574488276447});
        coordinates.add(new double[]{27.718012055693045,85.29571585531353});
        coordinates.add(new double[]{27.717897039147825,85.29568982972643});
        coordinates.add(new double[]{27.71778138074546,85.29566682383981});
        coordinates.add(new double[]{27.717665159752432,85.29564685342075});
        coordinates.add(new double[]{27.71754845582081,85.29562993215598});
        coordinates.add(new double[]{27.717431348933637,85.29561607164248});
        coordinates.add(new double[]{27.717313919350126,85.29560528137958});
        coordinates.add(new double[]{27.717196247550643,85.29559756876237});
        coordinates.add(new double[]{27.717078414181564,85.29559293907668});
        coordinates.add(new double[]{27.7169605,85.29559139549549});
        coordinates.add(new double[]{27.716842585818434,85.29559293907668});
        coordinates.add(new double[]{27.716724752449355,85.29559756876237});
        coordinates.add(new double[]{27.716607080649872,85.29560528137958});
        coordinates.add(new double[]{27.71648965106636,85.29561607164248});
        coordinates.add(new double[]{27.716372544179187,85.29562993215598});
        coordinates.add(new double[]{27.716255840247566,85.29564685342075});
        coordinates.add(new double[]{27.716139619254538,85.29566682383981});
        coordinates.add(new double[]{27.716023960852173,85.29568982972643});
        coordinates.add(new double[]{27.715908944306953,85.29571585531353});
        coordinates.add(new double[]{27.715794648445485,85.29574488276447});
        coordinates.add(new double[]{27.71568115160043,85.29577689218529});
        coordinates.add(new double[]{27.71556853155687,85.29581186163831});
        coordinates.add(new double[]{27.715456865498947,85.29584976715725});
        coordinates.add(new double[]{27.715346229957003,85.29589058276353});
        coordinates.add(new double[]{27.71523670075511,85.29593428048419});
        coordinates.add(new double[]{27.715128352959116,85.29598083037098});
        coordinates.add(new double[]{27.715021260825186,85.29603020052095});
        coordinates.add(new double[]{27.71491549774892,85.29608235709826});
        coordinates.add(new double[]{27.714811136215047,85.29613726435738});
        coordinates.add(new double[]{27.714708247747748,85.29619488466764});
        coordinates.add(new double[]{27.71460690286164,85.29625517853894});
        coordinates.add(new double[]{27.714507171013445,85.29631810464889});
        coordinates.add(new double[]{27.714409120554393,85.29638361987108});
        coordinates.add(new double[]{27.714312818683368,85.29645167930462});
        coordinates.add(new double[]{27.71421833140086,85.296522236305});
        coordinates.add(new double[]{27.714125723463738,85.29659524251596});
        coordinates.add(new double[]{27.714035058340855,85.2966706479027});
        coordinates.add(new double[]{27.713946398169554,85.29674840078614});
        coordinates.add(new double[]{27.713859803713092,85.29682844787833});
        coordinates.add(new double[]{27.713775334318978,85.29691073431898});
        coordinates.add(new double[]{27.713693047878323,85.2969952037131});
        coordinates.add(new double[]{27.713613000786136,85.29708179816956});
        coordinates.add(new double[]{27.7135352479027,85.29717045834086});
        coordinates.add(new double[]{27.71345984251596,85.29726112346374});
        coordinates.add(new double[]{27.713386836304995,85.29735373140086});
        coordinates.add(new double[]{27.713316279304617,85.29744821868337});
        coordinates.add(new double[]{27.713248219871073,85.2975445205544});
        coordinates.add(new double[]{27.713182704648894,85.29764257101345});
        coordinates.add(new double[]{27.713119778538946,85.29774230286164});
        coordinates.add(new double[]{27.713059484667635,85.29784364774775});
        coordinates.add(new double[]{27.713001864357377,85.29794653621505});
        coordinates.add(new double[]{27.71294695709825,85.29805089774892});
        coordinates.add(new double[]{27.712894800520946,85.29815666082519});
        coordinates.add(new double[]{27.71284543037098,85.29826375295912});
        coordinates.add(new double[]{27.712798880484183,85.29837210075512});
        coordinates.add(new double[]{27.712755182763527,85.29848162995701});
        coordinates.add(new double[]{27.71271436715724,85.29859226549895});
        coordinates.add(new double[]{27.71267646163831,85.29870393155687});
        coordinates.add(new double[]{27.712641492185277,85.29881655160044});
        coordinates.add(new double[]{27.712609482764464,85.29893004844548});
        coordinates.add(new double[]{27.712580455313525,85.29904434430696});
        coordinates.add(new double[]{27.712554429726424,85.29915936085217});
        coordinates.add(new double[]{27.712531423839803,85.29927501925454});
        coordinates.add(new double[]{27.712511453420742,85.29939124024757});
        coordinates.add(new double[]{27.712494532155972,85.2995079441792});
        coordinates.add(new double[]{27.712480671642485,85.29962505106636});
        coordinates.add(new double[]{27.71246988137958,85.29974248064988});
        coordinates.add(new double[]{27.712462168762364,85.29986015244936});
        coordinates.add(new double[]{27.712457539076684,85.29997798581843});
        coordinates.add(new double[]{27.712455995495496,85.3000959});
        coordinates.add(new double[]{27.712457539076684,85.30021381418157});
        coordinates.add(new double[]{27.712462168762364,85.30033164755065});
        coordinates.add(new double[]{27.71246988137958,85.30044931935012});
        coordinates.add(new double[]{27.712480671642485,85.30056674893365});
        coordinates.add(new double[]{27.712494532155972,85.30068385582081});
        coordinates.add(new double[]{27.712511453420742,85.30080055975243});
        coordinates.add(new double[]{27.712531423839803,85.30091678074547});
        coordinates.add(new double[]{27.712554429726424,85.30103243914783});
        coordinates.add(new double[]{27.712580455313525,85.30114745569304});
        coordinates.add(new double[]{27.712609482764464,85.30126175155452});
        coordinates.add(new double[]{27.712641492185277,85.30137524839957});
        coordinates.add(new double[]{27.71267646163831,85.30148786844313});
        coordinates.add(new double[]{27.71271436715724,85.30159953450105});
        coordinates.add(new double[]{27.712755182763527,85.301710170043});
        coordinates.add(new double[]{27.712798880484183,85.30181969924489});
        coordinates.add(new double[]{27.71284543037098,85.30192804704089});
        coordinates.add(new double[]{27.712894800520946,85.30203513917482});
        coordinates.add(new double[]{27.71294695709825,85.30214090225108});
        coordinates.add(new double[]{27.713001864357377,85.30224526378495});
        coordinates.add(new double[]{27.713059484667635,85.30234815225225});
        coordinates.add(new double[]{27.713119778538946,85.30244949713837});
        coordinates.add(new double[]{27.713182704648894,85.30254922898655});
        coordinates.add(new double[]{27.713248219871073,85.30264727944561});
        coordinates.add(new double[]{27.713316279304617,85.30274358131663});
        coordinates.add(new double[]{27.713386836304995,85.30283806859914});
        coordinates.add(new double[]{27.71345984251596,85.30293067653626});
        coordinates.add(new double[]{27.7135352479027,85.30302134165915});
        coordinates.add(new double[]{27.713613000786136,85.30311000183045});
        coordinates.add(new double[]{27.713693047878323,85.30319659628691});
        coordinates.add(new double[]{27.713775334318978,85.30328106568102});
        coordinates.add(new double[]{27.713859803713092,85.30336335212168});
        coordinates.add(new double[]{27.713946398169554,85.30344339921386});
        coordinates.add(new double[]{27.714035058340855,85.3035211520973});
        coordinates.add(new double[]{27.714125723463738,85.30359655748404});
        coordinates.add(new double[]{27.71421833140086,85.30366956369501});
        coordinates.add(new double[]{27.714312818683368,85.30374012069538});
        coordinates.add(new double[]{27.714409120554393,85.30380818012893});
        coordinates.add(new double[]{27.714507171013445,85.30387369535111});
        coordinates.add(new double[]{27.71460690286164,85.30393662146106});
        coordinates.add(new double[]{27.714708247747748,85.30399691533236});
        coordinates.add(new double[]{27.714811136215047,85.30405453564262});
        coordinates.add(new double[]{27.71491549774892,85.30410944290175});
        coordinates.add(new double[]{27.715021260825186,85.30416159947906});
        coordinates.add(new double[]{27.715128352959116,85.30421096962903});
        coordinates.add(new double[]{27.71523670075511,85.30425751951582});
        coordinates.add(new double[]{27.715346229957003,85.30430121723647});
        coordinates.add(new double[]{27.715456865498947,85.30434203284275});
        coordinates.add(new double[]{27.71556853155687,85.30437993836169});
        coordinates.add(new double[]{27.71568115160043,85.30441490781472});
        coordinates.add(new double[]{27.715794648445485,85.30444691723554});
        coordinates.add(new double[]{27.715908944306953,85.30447594468647});
        coordinates.add(new double[]{27.716023960852173,85.30450197027358});
        coordinates.add(new double[]{27.716139619254538,85.3045249761602});
        coordinates.add(new double[]{27.716255840247566,85.30454494657926});
        coordinates.add(new double[]{27.716372544179187,85.30456186784403});
        coordinates.add(new double[]{27.71648965106636,85.30457572835752});
        coordinates.add(new double[]{27.716607080649872,85.30458651862043});
        coordinates.add(new double[]{27.716724752449355,85.30459423123763});
        coordinates.add(new double[]{27.716842585818434,85.30459886092332});

        totalDistance = calculateTotalDistance(coordinatesList);
        totalTime = calcTime(coordinates);
    }

    public static double calculateTotalDistance(List<double[]> coordinates) {
        int numPoints = coordinates.size();
        double totalDistance = 0.0;

        for (int i = 0; i < numPoints - 1; i++) {
            double[] point1 = coordinates.get(i);
            double[] point2 = coordinates.get(i + 1);
            double distance = calculateDistance(point1, point2);
            totalDistance += distance;
        }
        return totalDistance;
    }

    public static double calculateDistance(double[] point1, double[] point2) {
        double lon1 = Math.toRadians(point1[1]);
        double lon2 = Math.toRadians(point2[1]);
        double lat1 = Math.toRadians(point1[0]);
        double lat2 = Math.toRadians(point2[0]);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Earth's radius in kilometers
        double radius = 6371;

        double distance = radius * c;
        return distance;
    }

    public static double calcTime(List<double[]> coordinates){
        double timeInSec = coordinates.size()*2;
        double time = timeInSec/60;
        return time;
    }
}