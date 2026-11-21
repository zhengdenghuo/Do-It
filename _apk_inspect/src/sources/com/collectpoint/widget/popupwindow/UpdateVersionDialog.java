package com.collectpoint.widget.popupwindow;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.BuildConfig;
import com.collectpoint.MyApp;
import com.collectpoint.net.remote.Injection;
import com.collectpoint.net.repo.UserRepo;
import com.collectpoint.utils.DownloadUtil;
import com.collectpoint.widget.popupwindow.SweetAlertDialog;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import java.io.File;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes2.dex */
public class UpdateVersionDialog extends Dialog implements View.OnClickListener {
    private String DownUrl;
    private Thread MyVersionRecord;
    Context context;
    private int deviceId;
    private int formWhere;
    DialogInterface.OnKeyListener keylistener;
    private Button mBtnCancel;
    private Button mBtnSure;
    private LinearLayout mLinButton;
    private LinearLayout mLinProgress;
    private ProgressBar mProgress;
    private TextView mProgressCount;
    private Disposable mSubscribe;
    private UserRepo mUserRepo;
    private TextView mVersionCode;
    private TextView mVersionContant;
    private String type;
    private String verCode;
    private String verContant;
    private Window window;

    public UpdateVersionDialog(Context context, String str, String str2, String str3, String str4, int i, int i2) {
        super(context);
        this.window = null;
        this.mVersionCode = null;
        this.mVersionContant = null;
        this.DownUrl = "";
        this.formWhere = 1;
        this.mBtnCancel = null;
        this.mBtnSure = null;
        this.mLinProgress = null;
        this.mLinButton = null;
        this.MyVersionRecord = null;
        this.keylistener = new DialogInterface.OnKeyListener() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                return i3 == 4 && keyEvent.getRepeatCount() == 0;
            }
        };
        this.context = context;
        this.DownUrl = str;
        this.verCode = str2;
        this.verContant = str3;
        this.type = str4;
        this.formWhere = i;
        this.deviceId = i2;
        this.mUserRepo = Injection.provideUserRepository(MyApp.getInstance());
        showDialog();
    }

    private void VersionRecordThread() {
        Thread thread = new Thread(new Runnable() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog.3
            @Override // java.lang.Runnable
            public void run() {
                UpdateVersionDialog.this.addAppVersionUser();
            }
        });
        this.MyVersionRecord = thread;
        thread.start();
    }

    static /* synthetic */ void lambda$addAppVersionUser$1(String str, Throwable th) throws Exception {
        if (th == null) {
            System.out.println("提交成功");
        } else {
            System.out.println("提交失败");
        }
    }

    public void addAppVersionUser() {
        this.mSubscribe = this.mUserRepo.addAppSoftUpdateNumber(this.deviceId).doOnSubscribe(new Consumer() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog$$ExternalSyntheticLambda1
            public final void accept(Object obj) {
                System.out.println("开始提交");
            }
        }).subscribe(new BiConsumer() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog$$ExternalSyntheticLambda0
            public final void accept(Object obj, Object obj2) throws Exception {
                UpdateVersionDialog.lambda$addAppVersionUser$1((String) obj, (Throwable) obj2);
            }
        });
    }

    public void dialogTitleLineColor() {
        View viewFindViewById = findViewById(getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(2131100232);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Disposable disposable = this.mSubscribe;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.mSubscribe.dispose();
    }

    public void downloadForWebView(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296384:
                dismiss();
                break;
            case 2131296385:
                addAppVersionUser();
                this.mLinButton.setVisibility(8);
                this.mLinProgress.setVisibility(0);
                if (!this.DownUrl.equals("")) {
                    if (!this.DownUrl.startsWith("http://") && !this.DownUrl.startsWith("https://")) {
                        ToastUtils.showLong("无效下载地址");
                        dismiss();
                        break;
                    } else {
                        DownloadUtil.getInstance().download(this.DownUrl, Environment.getExternalStorageDirectory() + "/ETPathApk", new DownloadUtil.OnDownloadListener() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog.1
                            @Override // com.collectpoint.utils.DownloadUtil.OnDownloadListener
                            public void onDownloadFailed() {
                                ToastUtils.showLong("apk下载失败");
                                if (UpdateVersionDialog.this.context != null) {
                                    new SweetAlertDialog(UpdateVersionDialog.this.context, 2).setTitleText("").setContentText("当前网络不好，是否用浏览器进行更新？").setCancelText("否").setConfirmText("是").showCancelButton(true).setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog.1.2
                                        @Override // com.collectpoint.widget.popupwindow.SweetAlertDialog.OnSweetClickListener
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                            UpdateVersionDialog.this.dismiss();
                                        }
                                    }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() { // from class: com.collectpoint.widget.popupwindow.UpdateVersionDialog.1.1
                                        @Override // com.collectpoint.widget.popupwindow.SweetAlertDialog.OnSweetClickListener
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                            UpdateVersionDialog.this.downloadForWebView(UpdateVersionDialog.this.DownUrl);
                                            UpdateVersionDialog.this.dismiss();
                                        }
                                    }).show();
                                }
                            }

                            @Override // com.collectpoint.utils.DownloadUtil.OnDownloadListener
                            public void onDownloadSuccess(String str, String str2) {
                                Uri uriFromFile;
                                ToastUtils.showLong("apk下载成功+" + str);
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setFlags(268435456);
                                if (Build.VERSION.SDK_INT >= 24) {
                                    uriFromFile = FileProvider.getUriForFile(UpdateVersionDialog.this.context, "com.collectpoint.provider", new File(Environment.getExternalStorageDirectory() + "/ETPathApk", str2));
                                    System.out.println("_______==:" + UpdateVersionDialog.this.context.getPackageName());
                                    UpdateVersionDialog.this.context.grantUriPermission(BuildConfig.APPLICATION_ID, uriFromFile, 1);
                                    intent.setFlags(1);
                                } else {
                                    uriFromFile = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/ETPathApk", str2));
                                }
                                intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
                                UpdateVersionDialog.this.context.startActivity(intent);
                                Process.killProcess(Process.myPid());
                            }

                            @Override // com.collectpoint.utils.DownloadUtil.OnDownloadListener
                            public void onDownloading(int i) {
                                UpdateVersionDialog.this.mProgress.setProgress(i);
                                UpdateVersionDialog.this.mProgressCount.setText(i + "%");
                            }
                        });
                        break;
                    }
                } else {
                    ToastUtils.showLong("无效下载地址");
                    break;
                }
                break;
        }
    }

    public void showDialog() {
        setContentView(2131492953);
        this.mVersionCode = (TextView) findViewById(2131297144);
        this.mVersionContant = (TextView) findViewById(2131297145);
        this.mProgress = (ProgressBar) findViewById(2131296744);
        this.mProgressCount = (TextView) findViewById(2131296747);
        this.mLinProgress = (LinearLayout) findViewById(2131296651);
        this.mLinButton = (LinearLayout) findViewById(2131296650);
        this.mBtnCancel = (Button) findViewById(2131296384);
        this.mBtnSure = (Button) findViewById(2131296385);
        this.mBtnCancel.setOnClickListener(this);
        this.mBtnSure.setOnClickListener(this);
        this.mVersionCode.setText("V" + this.verCode);
        this.mVersionContant.setText(this.verContant);
        this.mVersionContant.setMovementMethod(new ScrollingMovementMethod());
        if (TextUtils.equals("N", this.type)) {
            this.mBtnCancel.setVisibility(0);
            this.mBtnSure.setVisibility(0);
        } else {
            this.mBtnSure.setVisibility(0);
            this.mBtnCancel.setVisibility(8);
        }
        windowDeploy(0, 0);
        dialogTitleLineColor();
        show();
    }

    public void windowDeploy(int i, int i2) {
        setOnKeyListener(this.keylistener);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        this.window = window;
        window.setWindowAnimations(2131886646);
        this.window.setBackgroundDrawableResource(2131100232);
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        attributes.width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        attributes.x = i;
        attributes.y = i2;
        this.window.setAttributes(attributes);
    }
}
