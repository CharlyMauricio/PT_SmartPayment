package com.technical.test.smartpayment.ui.utils.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AuthField(
    label: String,
    input: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    errorSemantic: String = "",
    fieldSemantic: String = "",
    errorMessageId: Int? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(modifier = modifier,) {
        if (errorMessageId != null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics { testTag = errorSemantic },
                text = stringResource(id = errorMessageId)
            )
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth()
                .semantics { testTag = fieldSemantic },
            label = { Text(label) },
            value = input,
            onValueChange = { onTextChanged(it) },
            visualTransformation = visualTransformation,
            isError = errorMessageId != null
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun AuthFieldPreview() {
    AuthField(
        "Label",
        "correo",
        onTextChanged = {}
    )
}