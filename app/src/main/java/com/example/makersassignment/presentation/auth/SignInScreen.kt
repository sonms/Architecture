package com.example.makersassignment.presentation.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.example.makersassignment.R
import com.example.makersassignment.core.designsystem.component.CommonTextField
import com.example.makersassignment.core.type.TextFieldType
import com.example.makersassignment.core.common.extension.noRippleClickable
import com.example.makersassignment.presentation.auth.component.ErrorMessage
import timber.log.Timber

@Composable
fun SignInRoute(
    navigateHome: () -> Unit,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    SignInSideEffect.SignInSucceed -> {
                        Timber.d("SignInSucceed")
                        navigateHome()
                    }

                    SignInSideEffect.SignInFailed ->
                        Toast.makeText(context, getString(context, R.string.sign_in_error), Toast.LENGTH_SHORT).show()
                }
            }
    }

    SignInScreen(
        id = uiState.id,
        password = uiState.password,
        isIdError = uiState.isIdError,
        isPasswordError = uiState.isPasswordError,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onSignInClick = viewModel::onSignInClick
    )
}

@Composable
fun SignInScreen(
    id : String,
    password : String,
    isIdError : Boolean,
    isPasswordError : Boolean,
    onIdChange : (String) -> Unit,
    onPasswordChange : (String) -> Unit,
    onSignInClick : () -> Unit,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CommonTextField(
            text = id,
            onTextChange = onIdChange,
            type = TextFieldType.Id,
            modifier = Modifier,
        )
        if (isIdError) {
            ErrorMessage(
                text = stringResource(R.string.sign_in_id_error_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        CommonTextField(
            text = password,
            onTextChange = onPasswordChange,
            type = TextFieldType.Password,
            modifier = Modifier,
            isPasswordVisible = isPasswordVisible,
            suffix = {
                Icon(
                    imageVector = ImageVector.vectorResource(if (isPasswordVisible) R.drawable.ic_visibility_24 else R.drawable.ic_visibility_off_24),
                    contentDescription = null,
                    modifier = Modifier.noRippleClickable {
                        isPasswordVisible = !isPasswordVisible
                    },
                    tint = Color.LightGray
                )
            }
        )
        if (isPasswordError) {
            ErrorMessage(
                text = stringResource(R.string.sign_in_password_error_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onSignInClick,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.sign_in_button_text))
        }
    }
}