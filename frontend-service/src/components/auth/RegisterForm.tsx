import {type FormEvent, useState } from "react";
import type { RegisterFormData } from "../../types/auth";

interface RegisterFormProps {
    onSubmit: (data: RegisterFormData) => void;
    onLoginClick: () => void;
}

function RegisterForm({ onSubmit, onLoginClick }: RegisterFormProps) {
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");
    const [passportId, setPassportId] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return;
        }

        onSubmit({
            name,
            surname,
            passportId,
            email,
            password,
        });
    };

    return (
        <form onSubmit={handleSubmit}>

            <div className="form-field">
                <label htmlFor="register-name">Name</label>

                <input
                    id="register-name"
                    type="text"
                    value={name}
                    onChange={(event) => setName(event.target.value)}
                    placeholder="Enter your name"
                    required
                />
            </div>

            <div className="form-field">
                <label htmlFor="register-surname">Surname</label>

                <input
                    id="register-surname"
                    type="text"
                    value={surname}
                    onChange={(event) => setSurname(event.target.value)}
                    placeholder="Enter your surname"
                    required
                />
            </div>

            <div className="form-field">
                <label htmlFor="register-passport-id">Passport id</label>

                <input
                    id="register-passport-id"
                    type="text"
                    value={passportId}
                    onChange={(event) => setPassportId(event.target.value)}
                    placeholder="Enter your passport id"
                    required
                />
            </div>

            <div className="form-field">
                <label htmlFor="register-email">Email</label>

                <input
                    id="register-email"
                    type="email"
                    value={email}
                    onChange={(event) => setEmail(event.target.value)}
                    placeholder="Enter your email"
                    required
                />
            </div>

            <div className="form-field">
                <label htmlFor="register-password">Password</label>

                <input
                    id="register-password"
                    type="password"
                    value={password}
                    onChange={(event) => setPassword(event.target.value)}
                    placeholder="Create a password"
                    minLength={8}
                    required
                />
            </div>

            <div className="form-field">
                <label htmlFor="register-confirm-password">
                    Confirm password
                </label>

                <input
                    id="register-confirm-password"
                    type="password"
                    value={confirmPassword}
                    onChange={(event) =>
                        setConfirmPassword(event.target.value)
                    }
                    placeholder="Repeat your password"
                    minLength={8}
                    required
                />
            </div>

            <button type="submit">
                Sign up
            </button>

            <p className="switch-auth">
                Already have an account?{" "}
                <button
                    type="button"
                    className="link-button"
                    onClick={onLoginClick}
                >
                    Sign in
                </button>
            </p>
        </form>
    );
}

export default RegisterForm;