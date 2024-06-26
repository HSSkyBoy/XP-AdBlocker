package com.aviraxp.xpblocker.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class LicensesDialog extends AlertDialog.Builder {

    private final Context ctx;

    LicensesDialog(Context context, String url) {
        super(context);
        ctx = context;
        init(url);
    }

    private void init(String url) {
        WebView view = new WebView(ctx);
        view.loadUrl(url);
        view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.startsWith("http")) {
                    view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                } else {
                    return false;
                }
            }
        });
        setView(view);
    }
}