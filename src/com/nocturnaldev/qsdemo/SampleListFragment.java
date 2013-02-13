package com.nocturnaldev.qsdemo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SampleListFragment extends ListFragment {
    
    private ListView lv;
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, 
                getResources().getStringArray(R.array.colors)));

        lv = getListView();
        
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lv.setMultiChoiceModeListener(new SampleMultiChoiceModeListener());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        lv.setItemChecked(position, true);
    }

    private class SampleMultiChoiceModeListener implements MultiChoiceModeListener {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.setTitle(getSelectedItemsString());
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }
        
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id,
                boolean checked) {
            mode.setTitle(getSelectedItemsString());
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) { }
        
        private String getSelectedItemsString() {
            int count = lv.getCheckedItemCount();
            return getResources().getQuantityString(R.plurals.itemsSelected, count, count);
        }
        
    }
    
}
