package es.ulpgc.eite.juansocas.surfco.data;

import java.util.List;

public interface RepositoryContract {

    void loadTODO(boolean clearFirst, FetchUsersDataCallback callbackUsers, FetchPicosDataCallback callbackPicos, FetchIntermediaDataCallback callbackIntermedia);


    void clarAllTables();

    void loadUsers(boolean clearFirst, FetchUsersDataCallback callback);

    void loadPicos(boolean clearFirst, FetchPicosDataCallback callback);




    void insertUser(User user, final OnUsersUpdated callback);

   // void insertUser(User user, final OnUserInserted callback);
   void   getUsers1(final GetUsersListCallback callback);
   void getUsers(final OnUsergeted callback);
   void getUsersList(RepositoryContract.GetUsersListCallback callback);
   void getPicosList(RepositoryContract.GetPicosListCallback callback);
   void getIntermediaList(RepositoryContract.GetTABLAIntermediaListCallback callback);
   void getgetAllPicos(final  OnPicosgetted callback);


   //void loadUsers(boolean clearfirst, SurfandCoRepository.);
/*
    interface OnUserInserted{
        void onUserInserted(User user);
    }


 */
    interface VerificacionCredencialesCallback{

   }
   interface FetchCleanTablesCallback{

   }

    interface FetchUsersDataCallback{
        void onUsersDataFetched(boolean error);

    }
    interface FetchPicosDataCallback{
        void onPicosDataFetched(boolean error);
    }
    interface FetchIntermediaDataCallback{
        void onIntermedaDataFetched(boolean error);
    }

    interface GetUsersListCallback{
        void setUsersList(List<User> users);
    }
    interface GetPicosListCallback{
        void setPicosList(List<Picos> picos);
    }
    interface GetTABLAIntermediaListCallback{
        void setUsers_picos(List<User_Picos> users_picos);
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
