package com.rijo.ubertest.ui.startUpScreen;

import com.rijo.ubertest.dataRepository.Const;
import com.rijo.ubertest.dataRepository.ImageRepository;
import com.rijo.ubertest.dataRepository.domain.Images;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rijogeorge on 10/6/17.
 */

public class StartupActivityPresenterImpl implements StartupActivityContract.UserActionListener{

    StartupActivityContract.View view;
    ImageRepository imageRepository;

    public StartupActivityPresenterImpl(StartupActivityContract.View view, ImageRepository imageRepository) {
        this.view = view;
        this.imageRepository = imageRepository;
    }

    @Override
    public void getImages() {

        Images images=null;
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<Images> imageFuture=executor.submit(new Callable<Images>() {
            @Override
            public Images call() throws Exception {
                return imageRepository.getImagesFrom(Const.flickerBaseUrl);
            }
        });
        try {
            images=imageFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(images!=null) {
            view.showImagesList(images);
        } else {
            view.showImagesNotAvailableScreen();
        }
    }
    }

