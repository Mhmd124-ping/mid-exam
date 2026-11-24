package com.example.mid_exam_mohamedhamdan;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ModeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private Button btnSetMode;
    private final String[] tabNames = {"First", "Second", "Third"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        // تفعيل زر Up Button للعودة إلى MainActivity
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        btnSetMode = findViewById(R.id.btnSetMode);

        TabsAdapter adapter = new TabsAdapter(this);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(tabNames[position])
        ).attach();

        // قائمة Set Mode المنبثقة
        btnSetMode.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(ModeActivity.this, btnSetMode);
            popupMenu.getMenu().add("Light");
            popupMenu.getMenu().add("Night");
            popupMenu.getMenu().add("System");

            popupMenu.setOnMenuItemClickListener(item -> {
                String title = item.getTitle().toString();
                if ("Light".equals(title)) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else if ("Night".equals(title)) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else if ("System".equals(title)) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
                return true;
            });
            popupMenu.show();
        });

        // سلوك زر الرجوع حسب التبويب الحالي
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem == 1 || currentItem == 2) {
                    viewPager2.setCurrentItem(0, true);
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}