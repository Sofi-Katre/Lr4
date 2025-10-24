package com.example.lr4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button; // Не забудьте импортировать Button
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class EveningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evening); // Устанавливаем макет evening.xml

        // Найдите ListView по его ID
        ListView morningList = findViewById(R.id.eveninglist);

        // Создайте массив строк с вашими задачами
        String[] tasks = {"Сериал Шерлок", "Гарри Поттер и Кубок Огня", "SPA в ванной", "Почитать перед сном книгу"};

        // Создайте стандартный ArrayAdapter, используя встроенный макет simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        // Установите адаптер для ListView
        morningList.setAdapter(adapter);

        // Найдем кнопки по их ID
        Button backButton = findViewById(R.id.btn_back);
        Button nextButton = findViewById(R.id.btn_next2);

        // Слушатель для кнопки "назад"
        backButton.setOnClickListener(v -> {
            // Создаём Intent для возврата на MainActivity
            Intent intent = new Intent(EveningActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Слушатель для кнопки "далее"
        nextButton.setOnClickListener(v -> {
            // Создаем Intent для запуска EveningActivity
            Intent intent = new Intent(EveningActivity.this, NightActivity.class);
            startActivity(intent);
        });

    }
}
