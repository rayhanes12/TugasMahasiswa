package Network;

import Model.ResponseModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL
                ( "https://harber.mimoapps.xyz/api/getaccess.php");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponseModel> responseModels = new ArrayList<>();
        for (int i=0; i< responseJSON.length(); i++){
            ResponseModel resmodel = new ResponseModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resmodel.setMessage(myJSONObject.getString("message"));
            resmodel.setStatus(myJSONObject.getString("status"));
            resmodel.setStatus(myJSONObject.getString("comment"));
            responseModels.add(resmodel);
        }
        System.out.println("Response arev: ");
        for (int index=0; index<responseModels.size(); index++) {
            System.out.println("MASSAGE : " + responseModels.get(index).getMessage());
            System.out.println("STATUS : " + responseModels.get(index).getStatus());
            System.out.println("COMMENT : " + responseModels.get(index).getComments());
        }


    }
}
