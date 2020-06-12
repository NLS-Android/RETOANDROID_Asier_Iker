package com.ciber.retoandroid_asier_iker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AllowanceAdapter extends RecyclerView.Adapter<AllowanceAdapter.allowanceView> {

    private List<Allowance> allowanceList=new ArrayList<>();
    private Context context;
    private ArrayList<Allowance>allowanceArrayList;
    private OPAllowances opAllowances;

    public AllowanceAdapter( OPAllowances opAllowances, ArrayList<Allowance> allowanceList) {
        this.opAllowances = opAllowances;
        this.allowanceList = allowanceList;
        this.allowanceArrayList=allowanceList;
    }

    @NonNull
    @Override
    public allowanceView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_show,viewGroup,false);

        return new allowanceView(view);
    }

    @Override
    public void onBindViewHolder(allowanceView allowanceView, int i) {
        Allowance allowance = allowanceList.get(i);
        allowanceView.txtCodeAllowanceShow.setText(String.valueOf(allowance.getCode()));
        allowanceView.txtExpenseNameAllowance.setText(allowance.getAllowancename());
        allowanceView.txtStartDateAllowance.setText(allowance.getAllowancestartdate());
        allowanceView.txtEndDateAllowance.setText(allowance.getAllowanceenddate());
        allowanceView.txtLocationAllowance.setText(allowance.getAllowancelocation());
        allowanceView.txtTransportAllowance.setText(allowance.getAllowancetransport());
        allowanceView.txtTravelledAllowance.setText(allowance.getAllowancetravelleddistances());
        allowanceView.txtTollAllowance.setText(allowance.getAllowancetollamount());
        allowanceView.txtParkingAllowance.setText(allowance.getAllowanceparkingamount());
        allowanceView.txtTotalPrice.setText(allowance.getTotalprice());
        allowanceView.btnEditAllowance.setOnClickListener(new AllowanceAdapter.EditEvent(allowance));
        allowanceView.btnDeleteAllowance.setOnClickListener(new AllowanceAdapter.DeleteEvent(allowance));

    }

    @Override
    public int getItemCount() { return allowanceList.size(); }

    public void addAllowance(Allowance allowance) {
        allowanceList.add(allowance);
        this.notifyDataSetChanged();
    }
    public void deleteAllowance(Allowance allowance) {
        allowanceList.remove(allowance);
        this.notifyDataSetChanged();
    }

    class EditEvent implements View.OnClickListener{
        private Allowance allowance;
        public EditEvent(Allowance allowance) {
            this.allowance = allowance;
        }
        @Override
        public void onClick(View view) {
            opAllowances.OptionEditAllowance(allowance);
        }
    }

    class DeleteEvent implements View.OnClickListener {

        private Allowance allowance;

        public DeleteEvent(Allowance allowance) {
            this.allowance = allowance;
        }

        @Override
        public void onClick(View view) {
            opAllowances.OptionDeleteAllowance(allowance);
        }
    }

    public class allowanceView extends RecyclerView.ViewHolder {

        private TextView txtCodeAllowanceShow, txtExpenseNameAllowance, txtStartDateAllowance, txtEndDateAllowance, txtLocationAllowance, txtTransportAllowance, txtTravelledAllowance, txtTollAllowance, txtParkingAllowance, txtTotalPrice;
        private Button btnEditAllowance, btnDeleteAllowance;

        public allowanceView(View itemView) {
            super(itemView);
            txtCodeAllowanceShow = itemView.findViewById(R.id.txtCodeAllowanceShow);
            txtExpenseNameAllowance = itemView.findViewById(R.id.txtExpenseNameAllowance);
            txtStartDateAllowance = itemView.findViewById(R.id.txtStartDateAllowance);
            txtEndDateAllowance = itemView.findViewById(R.id.txtEndDateAllowance);
            txtLocationAllowance = itemView.findViewById(R.id.txtLocationAllowance);
            txtTransportAllowance = itemView.findViewById(R.id.txtTransportAllowance);
            txtTravelledAllowance = itemView.findViewById(R.id.txtTravelledAllowance);
            txtTollAllowance = itemView.findViewById(R.id.txtTollAllowance);
            txtParkingAllowance = itemView.findViewById(R.id.txtParkingAllowance);
            txtTotalPrice = itemView.findViewById(R.id.txtTotalPrice);
            btnEditAllowance = itemView.findViewById(R.id.btnEditAllowance);
            btnDeleteAllowance = itemView.findViewById(R.id.btnDeleteAllowance);
        }
    }
}
