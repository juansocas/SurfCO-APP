package es.ulpgc.eite.juansocas.surfco.data;

import java.util.List;

public interface RepositoryContract {

    void loadUsers(boolean clearFirst, FetchUsersDataCallback callback);

    void insertUser(User user, final OnUsersUpdated callback);

   // void insertUser(User user, final OnUserInserted callback);
   void getUsers(final OnUsergeted callback);
   void getUsersList(RepositoryContract.GetUsersListCallback callback);
   void getgetAllPicos(final  OnPicosgetted callback);


   //void loadUsers(boolean clearfirst, SurfandCoRepository.);
/*
    interface OnUserInserted{
        void onUserInserted(User user);
    }


 */
    interface VerificacionCredencialesCallback{

   }

    interface FetchUsersDataCallback{
        void onUsersDataFetched(boolean error);

    }
    interface GetUsersListCallback{
        void setUsersList(List<User> users);
    }


    interface OnUseradded{
        void onUseradded();
    }
    interface OnUsergeted{
        void  onUsergeted(List<User> users);

    }
    interface OnPicosgetted{
        void onPicosgetted(List<Picos> picos);

    }
    interface OnUsersUpdated{
         void onUsersUpdated(List<User> users);
    }



}
