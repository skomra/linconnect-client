/*    
 	LinConnect: Mirror Android notifications on Linux Desktop

    Copyright (C) 2013  Will Hauck

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.willhauck.linconnectclient;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationService extends NotificationListenerService {
	private static final String TAG = "NotificationService";

	@Override
	public void onNotificationPosted(StatusBarNotification arg0) {
		NotificationUtilities.sendData(getApplicationContext(),
				arg0.getNotification(), arg0.getPackageName());

		cancelNotification(arg0.getKey());
		Log.i(TAG, "cleared notification:" + arg0.toString());
	}

	@Override
	public void onNotificationRemoved(StatusBarNotification arg0) {
	}

}
