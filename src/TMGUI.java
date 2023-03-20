import Model.ResponseModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class TMGUI extends JFrame{
    private JButton SUBMITButton;
    private JTextField lbMessage;
    private JTextField lbStatus;
    private JTextField lbComment;
    private JButton CLOSEButton;
    private JPanel JPanel;
    private JTextField JumKata;
    private JButton CLEARButton;



    public TMGUI() throws IOException{
        setContentPane(JPanel);
        setTitle("TM01_22090129_RayhanEugeneSaputra");
        setSize(400,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        SUBMITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == SUBMITButton) {
                    try {
                        URL url = new URL("https://harber.mimoapps.xyz/api/getaccess.php");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        JSONArray jsonArray = new JSONArray(response.toString());
                        ArrayList<ResponseModel> parsedList = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            ResponseModel resModel = new ResponseModel();
                            JSONObject myJSONObject = jsonArray.getJSONObject(i);
                            resModel.setMessage(myJSONObject.getString("message"));
                            resModel.setStatus(myJSONObject.getString("status"));
                            resModel.setComments(myJSONObject.getString("comment"));
                            parsedList.add(resModel);

                        }
                        for (int index = 0; index < parsedList.size();index++){
                            lbMessage.setText(parsedList.get(index).getMessage());
                            lbStatus.setText(parsedList.get(index).getStatus());
                            lbComment.setText(parsedList.get(index).getComments());

                            JumKata.setText(String.valueOf(parsedList.get(index).getMessage().length()));
                        }


                    } catch (IOException ex) {
                        System.out.println("Data Tidak Terbaca");

                    } catch (JSONException ex) {
                        System.out.println("Data Tidak Valid");
                    }
                }

            }
        });
        CLOSEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbMessage.setText("0");
                lbStatus.setText("0");
                lbComment.setText("0");
            }
        });
    }

    public static void main(String[] args) throws IOException {
        TMGUI myTMGUI = new TMGUI();
    }
}
