package com.sandeep.baatchit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sandeep.baatchit.chats.Chatfragment;
import com.sandeep.baatchit.findfriends.FindFriendsFragment;
import com.sandeep.baatchit.requests.RequestFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position)
        {
            case 0:
                Chatfragment chatfragment = new Chatfragment();
                return chatfragment;
            case 1:
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;
            case 2:
                FindFriendsFragment findFriendsFragment = new FindFriendsFragment();
                return findFriendsFragment;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
