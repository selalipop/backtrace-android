package backtraceio.library.common;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

public class PermissionHelper {
    private Context context;

    public PermissionHelper(Context context)
    {
        this.context = context;
    }

    public boolean isPermissionForBluetoothGranted()
    {
        return ContextCompat.checkSelfPermission( this.context, Manifest.permission.BLUETOOTH ) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean isPermissionForInternetGranted()
    {
        return ContextCompat.checkSelfPermission( this.context, Manifest.permission.INTERNET ) == PackageManager.PERMISSION_GRANTED;
    }
}
