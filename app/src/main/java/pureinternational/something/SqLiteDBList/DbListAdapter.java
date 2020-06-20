package pureinternational.something.SqLiteDBList;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import pureinternational.something.R;

public class DbListAdapter extends ArrayAdapter<DbListData> {

    Context mCtx;
    int dbListLayout;
    List<DbListData> dblist;
    SQLiteDatabase mDatabase;

    public DbListAdapter(@NonNull Context context, int resource, @NonNull List<DbListData> objects) {
        super(context, resource, objects);
        this.mCtx = mCtx;
        this.dbListLayout = dbListLayout;
        this.dblist = dblist;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LF = LayoutInflater.from(getContext());
        View customView = LF.inflate(R.layout.db_list_layout, parent, false);
        final DbListData dblistdata = dblist.get(position);

        TextView TV1 = customView.findViewById(R.id.textViewName);
        TextView TV2 = customView.findViewById(R.id.textViewDepartment);
        TextView TV3 = customView.findViewById(R.id.textViewSalary);
        TextView TV4 = customView.findViewById(R.id.textViewDate);

        Button btn1 = customView.findViewById(R.id.btn_edit);
        Button btn2 = customView.findViewById(R.id.btn_update);

        String name = getItem(position).getName();
        String department = getItem(position).getDept();
        Double salary = getItem(position).getSalary();
        String date = getItem(position).getJoiningdate();

        TV1.setText(name);
        TV2.setText(department);
        TV3.setText(salary.toString());
        TV4.setText(date);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmployee(dblistdata);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab = new AlertDialog.Builder(mCtx);
                ab.setMessage("Are you sure?");
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM employees WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{dblistdata.getId()});
                        reloadEmployeesFromDatabase();
                    }
                });
                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //dialogInterface.cancel();
                    }
                });
                AlertDialog AD = ab.create();
                AD.show();
            }
        });

        return customView;
    }


    private void updateEmployee(final DbListData dblist) {
        AlertDialog.Builder ab = new AlertDialog.Builder(mCtx);
        LayoutInflater LF = LayoutInflater.from(mCtx);
        View customView = LF.inflate(R.layout.db_list_layout_update, null);
        ab.setView(customView);

        final EditText editTextName = customView.findViewById(R.id.update_name);
        final EditText editTextSalary = customView.findViewById(R.id.update_salary);
        final Spinner editSpinner = customView.findViewById(R.id.spinner);

        editTextName.setText(dblist.getName());
        editTextSalary.setText(String.valueOf(dblist.getSalary()));

        final AlertDialog AD = ab.create();
        AD.show();

        customView.findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String department = editSpinner.getSelectedItem().toString().trim();
                String salary = editTextSalary.getText().toString().trim();

                if(name.isEmpty()){
                    editTextName.setError("Name cant be blank");
                    editTextName.requestFocus();
                    return;
                }
                if(salary.isEmpty()){
                    editTextSalary.setError("salary cant be blank");
                    editTextSalary.requestFocus();
                    return;
                }

                String sql = "UPDATE employees \n"+
                        "SET name = ?, \n"+
                        "department = ?, \n"+
                        "salary = ?, \n"+
                        "WHERE id = ?;\n";

                mDatabase.execSQL(sql, new String[]{name, department, salary,String.valueOf(dblist.getId())});
                Toast.makeText(mCtx, "Updated", Toast.LENGTH_SHORT).show();
                reloadEmployeesFromDatabase();

                AD.dismiss();
            }
        });
    }
    private void reloadEmployeesFromDatabase(){
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM employees",null);
        if(cursor.moveToFirst()){
            dblist.clear();
            do {
                dblist.add(new DbListData(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getDouble(4)

                ));
            }while (cursor.moveToNext());
        }
       cursor.close();
        notifyDataSetChanged();
    }
}
