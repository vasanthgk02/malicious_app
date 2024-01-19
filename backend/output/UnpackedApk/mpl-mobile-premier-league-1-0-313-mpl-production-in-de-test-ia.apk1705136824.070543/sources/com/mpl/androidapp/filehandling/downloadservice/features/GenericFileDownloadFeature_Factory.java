package com.mpl.androidapp.filehandling.downloadservice.features;

import android.content.Context;
import com.google.gson.Gson;
import com.mpl.androidapp.filehandling.downloadservice.usecases.CheckConnectivityUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.DeleteExistingFileUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.InitDownloadManagerUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.MplFileCreationUseCase;
import com.mpl.androidapp.filehandling.downloadservice.usecases.ValidateInputParamsUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class GenericFileDownloadFeature_Factory implements Factory<GenericFileDownloadFeature> {
    public final Provider<CheckConnectivityUseCase> checkConnectivityUseCaseProvider;
    public final Provider<Context> contextProvider;
    public final Provider<DeleteExistingFileUseCase> deleteExistingFileUseCaseProvider;
    public final Provider<Gson> gsonProvider;
    public final Provider<InitDownloadManagerUseCase> initDownloadManagerUseCaseProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<MplFileCreationUseCase> mplFileCreationUseCaseProvider;
    public final Provider<ValidateInputParamsUseCase> validateInputParamsUseCaseProvider;

    public GenericFileDownloadFeature_Factory(Provider<CheckConnectivityUseCase> provider, Provider<ValidateInputParamsUseCase> provider2, Provider<DeleteExistingFileUseCase> provider3, Provider<MplFileCreationUseCase> provider4, Provider<InitDownloadManagerUseCase> provider5, Provider<Gson> provider6, Provider<Context> provider7, Provider<CoroutineDispatcher> provider8) {
        this.checkConnectivityUseCaseProvider = provider;
        this.validateInputParamsUseCaseProvider = provider2;
        this.deleteExistingFileUseCaseProvider = provider3;
        this.mplFileCreationUseCaseProvider = provider4;
        this.initDownloadManagerUseCaseProvider = provider5;
        this.gsonProvider = provider6;
        this.contextProvider = provider7;
        this.ioDispatcherProvider = provider8;
    }

    public static GenericFileDownloadFeature_Factory create(Provider<CheckConnectivityUseCase> provider, Provider<ValidateInputParamsUseCase> provider2, Provider<DeleteExistingFileUseCase> provider3, Provider<MplFileCreationUseCase> provider4, Provider<InitDownloadManagerUseCase> provider5, Provider<Gson> provider6, Provider<Context> provider7, Provider<CoroutineDispatcher> provider8) {
        GenericFileDownloadFeature_Factory genericFileDownloadFeature_Factory = new GenericFileDownloadFeature_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
        return genericFileDownloadFeature_Factory;
    }

    public static GenericFileDownloadFeature newInstance(CheckConnectivityUseCase checkConnectivityUseCase, ValidateInputParamsUseCase validateInputParamsUseCase, DeleteExistingFileUseCase deleteExistingFileUseCase, MplFileCreationUseCase mplFileCreationUseCase, InitDownloadManagerUseCase initDownloadManagerUseCase, Gson gson, Context context, CoroutineDispatcher coroutineDispatcher) {
        GenericFileDownloadFeature genericFileDownloadFeature = new GenericFileDownloadFeature(checkConnectivityUseCase, validateInputParamsUseCase, deleteExistingFileUseCase, mplFileCreationUseCase, initDownloadManagerUseCase, gson, context, coroutineDispatcher);
        return genericFileDownloadFeature;
    }

    public GenericFileDownloadFeature get() {
        return newInstance((CheckConnectivityUseCase) this.checkConnectivityUseCaseProvider.get(), (ValidateInputParamsUseCase) this.validateInputParamsUseCaseProvider.get(), (DeleteExistingFileUseCase) this.deleteExistingFileUseCaseProvider.get(), (MplFileCreationUseCase) this.mplFileCreationUseCaseProvider.get(), (InitDownloadManagerUseCase) this.initDownloadManagerUseCaseProvider.get(), (Gson) this.gsonProvider.get(), (Context) this.contextProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }
}
