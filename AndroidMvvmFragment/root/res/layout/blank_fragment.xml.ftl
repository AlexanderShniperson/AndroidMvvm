<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable name="viewModel"
                  type="${packageName}.${viewModelName}"/>
    </data>
    <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:gravity="center"
                android:text="Hello"/>

    </FrameLayout>
</layout>