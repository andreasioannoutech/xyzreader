package com.example.xyzreader.ui;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.Query;

/**
 * Created by kikkos on 12/20/2016.
 */

public class ArticleDetailPagerAdapter extends FragmentStatePagerAdapter {
    private Cursor mCursor;

    public ArticleDetailPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(mCursor.getLong(Query._ID));
    }

    @Override
    public int getCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }


    /***********************************************************************************************
                                    Public Helper Methods
     **********************************************************************************************/
    public void swapCursor(Cursor cursor){
        this.mCursor = cursor;
        this.notifyDataSetChanged();
    }
}
