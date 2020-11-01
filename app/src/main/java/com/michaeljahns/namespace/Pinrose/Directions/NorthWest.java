package com.michaeljahns.namespace.Pinrose.Directions;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.fragment.app.Fragment;
        import androidx.navigation.Navigation;

        import com.michaeljahns.namespace.R;

public class NorthWest extends Fragment {

    public NorthWest() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_north_west, container, false);
        view.findViewById(R.id.textNorthWest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_northWest_to_pinrose);
            }
        });
        return view;
    }
}