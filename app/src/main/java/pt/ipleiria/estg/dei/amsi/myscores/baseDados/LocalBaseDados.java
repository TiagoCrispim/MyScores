package pt.ipleiria.estg.dei.amsi.myscores.baseDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

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
    private static final String EQUIPA_ID1 = "equipaA_id";
    private static final String EQUIPA_ID2 = "equipaB_id";
    private static final String GOLOS_EQUIPA1 = "golos_equipaA";
    private static final String GOLOS_EQUIPA2 = "golos_equipaB";

    //Tabela Equipa
    private static final String ID_EQUIPA = "id_equipa";
    private static final String ID_JOGADOR1 = "id_jogador1";
    private static final String ID_JOGADOR2 = "id_jogador2";
    private static final String ID_JOGADOR3 = "id_jogador3";
    private static final String ID_JOGADOR4 = "id_jogador4";
    private static final String ID_JOGADOR5 = "id_jogador5";
    private static final String ID_JOGADOR6 = "id_jogador6";
    private static final String ID_JOGADOR7 = "id_jogador7";
    private static final String ID_JOGADOR8 = "id_jogador8";
    private static final String ID_JOGADOR9 = "id_jogador9";
    private static final String ID_JOGADOR10 = "id_jogador10";

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

    private static final //onCreate tabela Equipa
            String createEquipaTable = "CREATE TABLE " + TABLE_NAME_EQUIPA + " ( " +
            ID_EQUIPA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ID_JOGADOR1 + " INTEGER NOT NULL, " +
            ID_JOGADOR2 + " INTEGER NOT NULL, " +
            ID_JOGADOR3 + " INTEGER NOT NULL, " +
            ID_JOGADOR4 + " INTEGER NOT NULL, " +
            ID_JOGADOR5 + " INTEGER NOT NULL, " +
            ID_JOGADOR6 + " INTEGER NOT NULL, " +
            ID_JOGADOR7 + " INTEGER NOT NULL, " +
            ID_JOGADOR8 + " INTEGER NOT NULL, " +
            ID_JOGADOR9 + " INTEGER NOT NULL, " +
            ID_JOGADOR10 + " INTEGER NOT NULL, " +
            " FOREIGN KEY (" + ID_JOGADOR1 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR2 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR3 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR4 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR5 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR6 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR7 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR8 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR9 +") references equipa(" + ID_USER +")," +
            " FOREIGN KEY (" + ID_JOGADOR10 +") references equipa(" + ID_USER +")" + ") ; ";

    private static final //onCreate tabela Jogo
            String createJogoTable = "CREATE TABLE " + TABLE_NAME_JOGO + " ( " +
            ID_JOGO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DATA_JOGO + " TEXT NOT NULL, " +
            HORA_JOGO + " TEXT NOT NULL, " +
            LOCAL_JOGO + " TEXT NOT NULL, " +
            EQUIPA_ID1 + " INTEGER, " +
            EQUIPA_ID2 + " INTEGER, " +
            GOLOS_EQUIPA1 + " INTEGER, " +
            GOLOS_EQUIPA2 + " INTEGER, " +
            " FOREIGN KEY (" + EQUIPA_ID1 +") references equipa(" + ID_EQUIPA +")," +
            " FOREIGN KEY (" + EQUIPA_ID2 +") references equipa(" + ID_EQUIPA +")" + ") ; ";

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
        db.execSQL(createEquipaTable);
        db.execSQL(createJogoTable);
        db.execSQL(createGolos_marcadosTable);
    }

    public LocalBaseDados(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.database = this.getWritableDatabase();

        Log.d("table", createUserTable);
        Log.d("table", createEquipaTable);
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

    //implementar metodos CRUD

    //Create - adicionar
    public void adicionarJogoBD(Jogo jogo){
        ContentValues values = new ContentValues();

        values.put(ID_JOGO, jogo.getId());
        values.put(LOCAL_JOGO, jogo.getLocal());
        values.put(DATA_JOGO, jogo.getData());
        values.put(HORA_JOGO, jogo.getHora());

        //this.database.insert(TABLE_NAME, null, values);
        this.database.insert(TABLE_NAME_JOGO, null, values);
        System.out.println("--> ADICIONAR JOGO BD ");

    }

    //read
    public ArrayList<Jogo> getAllJogosBD(){
        ArrayList<Jogo> jogos = new ArrayList<>();
        //esta instrução é mais propensa a Sql Injecton
        //Cursor cursor = this.database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        //por isso em alternativa podemos usar
        Cursor cursor = this.database.query(TABLE_NAME_JOGO, new String[]{
                        ID_JOGO, LOCAL_JOGO, DATA_JOGO,
                        HORA_JOGO, EQUIPA_ID1, EQUIPA_ID2,
                        GOLOS_EQUIPA1, GOLOS_EQUIPA2},
                null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                Jogo auxJogo = new Jogo(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                jogos.add(auxJogo);

            }while(cursor.moveToNext());
        }
        return jogos;
    }

    //update
    public boolean guardarJogoBD(Jogo jogo){
        ContentValues values = new ContentValues();

        values.put(ID_JOGO, jogo.getId());
        values.put(LOCAL_JOGO, jogo.getLocal());
        values.put(DATA_JOGO, jogo.getData());
        values.put(HORA_JOGO, jogo.getHora());

        return this.database.update(
                TABLE_NAME_JOGO, values, "id = ?", new String[]{"" + jogo.getId()}
        ) > 0;

    }

    //delete
    public boolean removerJogoBD(long idJogo){
        return (this.database.delete(TABLE_NAME_JOGO, "id = ?", new String[]{"" + idJogo}) == 1);
    }

    public void removerAllJogosBD() {
        this.database.delete(TABLE_NAME_JOGO, null, null);
    }


    /*public void adicionarJogo(Jogo jogo){
        ContentValues values = new ContentValues();

        values.put(ID_JOGO, jogo.getId());
        values.put(DATA_JOGO, jogo.getData());
        values.put(HORA_JOGO, jogo.getHora());
        values.put(LOCAL_JOGO, jogo.getLocal());
        values.put(ID_EQUIPA, jogo.getId_equipa());
        values.put(GOLOS_EQUIPA, jogo.getGolosEquipa());

        this.database.insert(TABLE_NAME, null, values);
    }

    public LinkedList<Jogo> getAllJogos(){
        LinkedList<Jogo> jogos = new LinkedList<>();
        Cursor cursor = this.database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(cursor.moveToFirst()){

        }
        return jogos;
    }*/

}
