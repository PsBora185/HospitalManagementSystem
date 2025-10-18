
INSERT INTO patient (name, dob, email, gender, blood_group)
VALUES
    ('aman', '2001-04-01', 'aman@gmail.com', 'Male', 'B_POSITIVE'),
    ('vijay', '2002-11-14', 'vijay@gmail.com', 'Male', 'A_POSITIVE'),
    ('vicky', '2004-10-4', 'vicky@gmail.com', 'Male', 'AB_POSITIVE'),
    ('sofia', '2003-08-24', 'sofia@gmail.com', 'Female', 'O_POSITIVE');

INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Sneha Sharma', 'Dermatology', 'sneha.sharma@example.com'),
    ('Dr. Arjun Kapoor', 'Orthopedics', 'arjun.kapoor@example.com');


INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
  ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
  ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
  ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
  ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
  ('2025-07-05 16:15:00', 'Consultation', 1, 4),
  ('2025-07-06 08:30:00', 'Allergy Treatment', 2, 1);