package hudiilfeld.theshoppingequalizer.authentication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hudiilfeld.theshoppingequalizer.MainActivity;
import hudiilfeld.theshoppingequalizer.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;


    private FirebaseAuth mAuth;

    GoogleApiClient mGoogleApiClient;

    String email, password;

    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.cardViewLogin)
    CardView _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;
    @BindView(R.id.fbLoginBtn)
    Button fbLoginBtn;
    @BindView(R.id.googleLoginBtn)
    Button googleLoginBtn;

    CallbackManager callbackManager;

    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;

    GoogleSignInClient mGoogleSignInClient;

    private static int RC_SIGN_IN = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();


        String webClientId = getString(R.string.web_client_id);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(webClientId)
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);


        googleLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });


        fbLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));
            }
        });

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        accessTokenTracker = new AccessTokenTracker() {
                            @Override
                            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

                                Profile.fetchProfileForCurrentAccessToken();
                                AccessToken.setCurrentAccessToken(currentAccessToken);

                            }
                        };
                        accessTokenTracker.startTracking();

                        profileTracker = new ProfileTracker() {
                            @Override
                            protected void onCurrentProfileChanged(Profile profile, Profile profile1) {

                            }
                        };
                        profileTracker.startTracking();

                        Profile profile = Profile.getCurrentProfile();
                        if (profile != null) {
                            String userName = profile.getName();
                            Uri userprofilePic = profile.getProfilePictureUri(150, 150);

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("userName", userName);
                            intent.putExtra("userprofilePic", userprofilePic);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login cancelled", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(getApplicationContext(), "Error occured during login", Toast.LENGTH_LONG).show();
                    }
                });




        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{

                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);

            } catch (ApiException e) {

                Log.w(TAG, "Google sign in failed", e);
                Toast.makeText(this, "Gooogle Auth failed", Toast.LENGTH_LONG);

            }

        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("userName", user.getDisplayName());
                            intent.putExtra("userprofilePic", user.getPhotoUrl());
                            startActivity(intent);
                        } else {

                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }






    public void startSignIn() {
        email = _emailText.getText().toString();
        password = _passwordText.getText().toString();

        if(email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Fields are empty!!", Toast.LENGTH_LONG).show();

        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        Log.w(TAG, "signInWithEmail", task.getException());
                        Toast.makeText(LoginActivity.this, "Sign-in unsuccessful", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(LoginActivity.this, "Sign-in Successful", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                }
            });
        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Somehting Went Wrong", Toast.LENGTH_LONG);
    }
}
