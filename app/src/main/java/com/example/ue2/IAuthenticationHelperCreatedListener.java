// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

// <ListenerSnippet>
package com.example.ue2;

import com.microsoft.identity.client.exception.MsalException;

public interface IAuthenticationHelperCreatedListener {
    void onCreated(final AuthenticationHelper authHelper);
    void onError(final MsalException exception);
}
// </ListenerSnippet>
