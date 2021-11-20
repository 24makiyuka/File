package com.example.file2;

import android.os.Bundle;
import android.os.FileUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.file2.databinding.ActivityMainBinding;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final String saveFileName = "memo.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSave.setOnClickListener(v -> save());
        
    }
    protected void onStart() {
        super.onStart();
        load();
    }

    protected void onStop() {
        super.onStop();
        save();
    }

    public void save() {
        String contents = binding.memo.getText().toString();
        FileUtils.writeFile(this, saveFileName, contents);
    }

    public void load() {
        try {
            String loadedContents = FileUtils.readFile(this,saveFileName);
            binding.memo.setText(loadedContents);
        } catch (FileNotFoundException e) {
            //do nothing
        }
    }
//    private void writeFile(String saveFileName, String data) {
//        try {
//            FileOutputStream fos = openFileOutput(saveFileName, Context.MODE_PRIVATE);
//            fos.write(data.getBytes(StandardCharsets.UTF_8));
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private String readFile(String saveFileName) throws FileNotFoundException {
//        FileInputStream fis = openFileInput(saveFileName);
//
//        InputStreamReader inputStreamReader =
//                new InputStreamReader(fis, StandardCharsets.UTF_8);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
//            String line = reader.readLine();
//            while (line != null) {
//                stringBuilder.append(line).append('\n');
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//        }
//        return stringBuilder.toString().trim();
//
//
//    }
//}


}