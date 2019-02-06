package pt.ipleiria.estg.dei.amsi.myscores.baseDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pt.ipleiria.estg.dei.amsi.myscores.classes.Jogo;
import pt.ipleiria.estg.dei.amsi.myscores.classes.User;

public class LocalBaseDados extends SQLiteOpenHelper {
    //CRIAR TABELA USER E FAZER RELAÇÕES DE TABELAS
    private static LocalBaseDados sInstance;
    private SQLiteDatabase db;

    private static final String DB_NAME = "jogosDB";
    private static final int DB_VERSION = 1;

    //Tabelas
    private static final String TABLE_NAME_JOGO = "Jogo";
    private static final String TABLE_NAME_EQUIPA = "Equipa";
    private static final String TABLE_NAME_GOLOS_JOGO = "Golos_jogo";
    private static final String TABLE_NAME_USER = "User";

    //Tabela User
    private static final String ID_USER = "id";
    private static final String USERNAME_USER = "username";
    private static final String NOME_USER = "nome";
    private static final String PASSWORD_USER = "password";
    private static final String EMAIL_USER = "email";
    private static final String AUTH_KEY = "auth_key";
    private static final String DATA_NASCIMENTO_USER = "dataNascimento";
    private static final String NACIONALIDADE_USER = "nacionalidade";

    //Tabela Jogo
    private static final String ID_JOGO = "id";
    private static final String DATA_JOGO = "data";
    private static final String HORA_JOGO = "hora";
    private static final String LOCAL_JOGO = "local";
    private static final String ID_JOGADOR1A = "id_jogador1A";
    private static final String ID_JOGADOR2A = "id_jogador2A";
    private static final String ID_JOGADOR3A = "id_jogador3A";
    private static final String ID_JOGADOR4A = "id_jogador4A";
    private static final String ID_JOGADOR5A = "id_jogador5A";
    private static final String ID_JOGADOR6A = "id_jogador6A";
    private static final String ID_JOGADOR7A = "id_jogador7A";
    private static final String ID_JOGADOR8A = "id_jogador8A";
    private static final String ID_JOGADOR9A = "id_jogador9A";
    private static final String ID_JOGADOR10A = "id_jogador10A";
    private static final String ID_JOGADOR1B = "id_jogador1B";
    private static final String ID_JOGADOR2B = "id_jogador2B";
    private static final String ID_JOGADOR3B = "id_jogador3B";
    private static final String ID_JOGADOR4B = "id_jogador4B";
    private static final String ID_JOGADOR5B = "id_jogador5B";
    private static final String ID_JOGADOR6B = "id_jogador6B";
    private static final String ID_JOGADOR7B = "id_jogador7B";
    private static final String ID_JOGADOR8B = "id_jogador8B";
    private static final String ID_JOGADOR9B = "id_jogador9B";
    private static final String ID_JOGADOR10B = "id_jogador10B";
    private static final String GOLOS_EQUIPA1 = "golos_equipaA";
    private static final String GOLOS_EQUIPA2 = "golos_equipaB";

    //Tabele Golos_jogo
    private static final String ID_GOLOS_JOGO = "id_golos_id";
    private static final String JOGADOR_ID = "jogador_id";
    private static final String GOLOS_MARCADOS = "golos_marcados";

    SQLiteDatabase database;

    //Iniciar base de dados

    private static final //onCreate tabela User
            String createUserTable = "CREATE TABLE " + TABLE_NAME_USER + " ( " +
            ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USERNAME_USER + " TEXT NOT NULL, " +
            NOME_USER + " TEXT NOT NULL, " +
            PASSWORD_USER + " TEXT NOT NULL, " +
            AUTH_KEY + " TEXT NOT NULL, " +
            EMAIL_USER + " TEXT NOT NULL, " +
            DATA_NASCIMENTO_USER + " TEXT NOT NULL, " +
            NACIONALIDADE_USER + " TEXT NOT NULL " + " ) ; ";

    private static final //onCreate tabela Jogo
            String createJogoTable = "CREATE TABLE " + TABLE_NAME_JOGO + " ( " +
            ID_JOGO + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            ID_JOGADOR1A + " INTEGER NOT NULL, " +
            ID_JOGADOR2A + " INTEGER NOT NULL, " +
            ID_JOGADOR3A + " INTEGER NOT NULL, " +
            ID_JOGADOR4A + " INTEGER NOT NULL, " +
            ID_JOGADOR5A + " INTEGER NOT NULL, " +
            ID_JOGADOR6A + " INTEGER, " +
            ID_JOGADOR7A + " INTEGER, " +
            ID_JOGADOR8A + " INTEGER, " +
            ID_JOGADOR9A + " INTEGER, " +
            ID_JOGADOR10A + " INTEGER, " +
            ID_JOGADOR1B + " INTEGER NOT NULL, " +
            ID_JOGADOR2B + " INTEGER NOT NULL, " +
            ID_JOGADOR3B + " INTEGER NOT NULL, " +
            ID_JOGADOR4B + " INTEGER NOT NULL, " +
            ID_JOGADOR5B + " INTEGER NOT NULL, " +
            ID_JOGADOR6B + " INTEGER, " +
            ID_JOGADOR7B + " INTEGER, " +
            ID_JOGADOR8B + " INTEGER, " +
            ID_JOGADOR9B + " INTEGER, " +
            ID_JOGADOR10B + " INTEGER, " +
            DATA_JOGO + " TEXT NOT NULL, " +
            HORA_JOGO + " TEXT NOT NULL, " +
            LOCAL_JOGO + " TEXT NOT NULL, " +
            GOLOS_EQUIPA1 + " INTEGER NOT NULL, " +
            GOLOS_EQUIPA2 + " INTEGER NOT NULL " + " ) ; ";

    private static final //onCreate tabela Golos_marcados
            String createGolos_marcadosTable = "CREATE TABLE " + TABLE_NAME_GOLOS_JOGO + " ( " +
            ID_GOLOS_JOGO + " INTEGER PRIMARY KEY, " +
            GOLOS_MARCADOS + " INTEGER NOT NULL, " +
            JOGADOR_ID + " INTEGRER, " +
            ID_JOGO + " INTEGER, " +
            " FOREIGN KEY (" + JOGADOR_ID + ") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGO + ") references equipa(" + ID_JOGO +")" + " ) ; ";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserTable);
        db.execSQL(createJogoTable);
        db.execSQL(createGolos_marcadosTable);
    }

    public LocalBaseDados(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.database = this.getWritableDatabase();

        Log.d("table", createUserTable);
        Log.d("table", createJogoTable);
        Log.d("table", createGolos_marcadosTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER + TABLE_NAME_JOGO + TABLE_NAME_EQUIPA + TABLE_NAME_GOLOS_JOGO);
        onCreate(db);
    }

    //Colocar User na BD Local
    public void InsertUser(User user){
        ContentValues values = new ContentValues();
        values.put(ID_USER, user.getId());
        values.put(USERNAME_USER, user.getUsername());
        values.put(NOME_USER, user.getNome());
        values.put(PASSWORD_USER, user.getPasswordHash());
        values.put(EMAIL_USER, user.getEmail());
        values.put(AUTH_KEY, user.getAuth_key());
        values.put(DATA_NASCIMENTO_USER, user.getDataNascimento());
        values.put(NACIONALIDADE_USER, user.getNacionalidade());
        db.insert(TABLE_NAME_USER, null, values);
    }

    public boolean CheckUser(int id){
        this.db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME_USER + " WHERE " + ID_USER + "=?", new String[]{id+""});
        if(cursor.moveToFirst()){
            return true;
        }
        return false;
    }

    public List<User> findAll() {
        List<User> usersLDB = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME_USER, null);
            if (cursor.moveToFirst()) {
                usersLDB = new ArrayList<User>();
                do {
                    User user = new User();
                    user.setId(cursor.getInt(0));
                    user.setUsername(cursor.getString(1));
                    user.setNome(cursor.getString(2));
                    user.setPasswordHash(cursor.getString(3));
                    user.setAuth_key(cursor.getString(4));
                    user.setEmail(cursor.getString(5));
                    user.setDataNascimento(cursor.getString(6));
                    user.setNacionalidade(cursor.getString(7));
                    usersLDB.add(user);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            usersLDB = null;
        }
        return usersLDB;
    }

    public List<User> search(String username) {
        List<User> usersLDB = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME_USER + " where " + USERNAME_USER + " like ?", new String[] { "%" + username + "%" });
            if (cursor.moveToFirst()) {
                usersLDB = new ArrayList<User>();
                do {
                    User user = new User();
                    user.setId(cursor.getInt(0));
                    user.setUsername(cursor.getString(1));
                    user.setNome(cursor.getString(2));
                    user.setPasswordHash(cursor.getString(3));
                    user.setAuth_key(cursor.getString(4));
                    user.setEmail(cursor.getString(5));
                    user.setDataNascimento(cursor.getString(6));
                    user.setNacionalidade(cursor.getString(7));
                    usersLDB.add(user);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            usersLDB = null;
        }
        return usersLDB;
    }

}
