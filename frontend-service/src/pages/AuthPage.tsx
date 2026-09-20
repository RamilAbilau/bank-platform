import { useState } from "react";
import LoginForm from "../components/auth/LoginForm";
import RegisterForm from "../components/auth/RegisterForm";
import type {
    LoginFormData,
    RegisterFormData,
} from "../types/auth";

type AuthMode = "login" | "register";

function AuthPage() {
    const [mode, setMode] = useState<AuthMode>("login");

    const handleLogin = (data: LoginFormData) => {
        console.log("Login:", data);
    };

    const handleRegister = (data: RegisterFormData) => {
        console.log("Register:", data);
    };

    return (
        <main className="auth-page">
            <section className="auth-card">
                <h1>V Bank</h1>

                {mode === "login" ? (
                    <LoginForm
                        onSubmit={handleLogin}
                        onRegisterClick={() => setMode("register")}
                    />
                ) : (
                    <RegisterForm
                        onSubmit={handleRegister}
                        onLoginClick={() => setMode("login")}
                    />
                )}
            </section>
        </main>
    );
}

export default AuthPage;