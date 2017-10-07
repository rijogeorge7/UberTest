package com.rijo.ubertest.ui.startUpScreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.rijo.ubertest.R;
import com.rijo.ubertest.dataRepository.ImageRepositoryImpl;
import com.rijo.ubertest.dataRepository.domain.Images;
import com.rijo.ubertest.ui.startUpScreen.adpters.ImageRecyclerAdapter;
import com.rijo.ubertest.util.Utilities;

public class StartupActivity extends AppCompatActivity implements StartupActivityContract.View{

    StartupActivityPresenterImpl presenter;
    private RecyclerView imageRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        ImageRepositoryImpl productRepository = new ImageRepositoryImpl();
        presenter = new StartupActivityPresenterImpl(this,productRepository);
        if(Utilities.IsInternetAvailable(getApplicationContext())) {
            presenter.getImages();

        }
        else {
            showNoNetworkDialog();
        }
    }

    private void showNoNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(StartupActivity.this);

        builder.setMessage(R.string.internet_dialog_message)
                .setTitle(R.string.internet_dialog_title);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        builder.show();
    }

    @Override
    public void showImagesNotAvailableScreen() {

    }

    @Override
    public void showImagesList(Images images) {
        ((ProgressBar)findViewById(R.id.progressBar)).setVisibility(View.GONE);
        imageRecyclerView=(RecyclerView)findViewById(R.id.imageList_recycler_view);
        imageRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,2);
        imageRecyclerView.setLayoutManager(mLayoutManager);
        ImageRecyclerAdapter adapter=new ImageRecyclerAdapter(images,getApplicationContext());
        imageRecyclerView.setAdapter(adapter);
    }
}
