import {type FormEvent, useState } from "react";
import type { LoginFormData } from "../../types/auth";

interface LoginFormProps {
    onSubmit: (data: LoginFormData) => void;
    onRegisterClick: () => void;
}

function LoginForm({ onSubmit, onRegisterClick }: LoginFormProps) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        onSubmit({
            email,
            password,
        });
    };

    return (
        <form onSubmit={handleSubmit}>

            <div className="form-field">
                <label htmlFor="login-email">Email</label>

                <input
                    id="login-email"
                    type="email"
                    value={email}
                    onChange={(event) => setEmail(event.target.value)}
                    placeholder="Enter your email"
                    required
                />
            </div>

            <div className="form-field">
                <label htmlFor="login-password">Password</label>

                <input
                    id="login-password"
                    type="password"
                    value={password}
                    onChange={(event) => setPassword(event.target.value)}
                    placeholder="Enter your password"
                    required
                />
            </div>

            <button type="submit">
                Sign in
            </button>

            <p className="switch-auth">
                Don't have an account?{" "}
                <button
                    type="button"
                    className="link-button"
                    onClick={onRegisterClick}
                >
                    Sign up
                </button>
            </p>
        </form>
    );
}

export default LoginForm;