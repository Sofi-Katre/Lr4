package com.example.lr4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.night); // Устанавливаем макет night.xml

        // Найдем кнопки по их ID
        Button backButton = findViewById(R.id.btn_back);
        Button questionButton = findViewById(R.id.btn_question);

        // Слушатель для кнопки "назад"
        backButton.setOnClickListener(v -> {
            // Создаем Intent для возврата на MainActivity
            Intent intent = new Intent(NightActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Слушатель для кнопки "вопрос"
        questionButton.setOnClickListener(v -> {
            // Создаем AlertDialog с вопросом
            new AlertDialog.Builder(NightActivity.this)
                    .setTitle("Вопрос")
                    .setMessage("Ты спишь?")
                    .setPositiveButton("Да", (dialog, which) -> {
                        // Если пользователь нажимает "Да", закрываем всё приложение
                        finishAffinity();
                    })
                    .setNegativeButton("Нет", (dialog, which) -> {
                        // Если пользователь нажимает "Нет", переходим на MainActivity
                        Intent intent = new Intent(NightActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    })
                    .show();
        });

    }
}
